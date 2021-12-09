package model;

import utils.Point;
import utils.Position;
import view.Command;
import view.GameResult;

import static utils.BoardUtils.changeStringArrayToIntArrayUsingSymbol;
import static utils.Parser.changeIntSymbol;

public class Board {

    private int[][] board;

    private Answer answer;

    private Board() {};

    Board(int[][] board) {
        this.board = board;
        this.answer = new Answer(board);
    }

    GameResult push(Command command) {
        GameResult gameResult = new GameResult();
        Point point = findPlayerPosition();

        int moveBlockX = point.getX() + command.getNextPosition().get(0);
        int moveBlockY = point.getY() + command.getNextPosition().get(1);
        int[][] newBoard = copyBoard();

        if (moveable(Position.of(moveBlockX, moveBlockY))) {
            int[][] updatedBoard = move(point, newBoard, Position.of(moveBlockX, moveBlockY));
            update(updatedBoard);
            gameResult.addBoard(this.getBoard());
        } else if (pushable(Position.of(moveBlockX, moveBlockY), command)) {
            int[][] updatedBoard = pushBall(point, newBoard, Position.of(moveBlockX, moveBlockY), command);
            update(updatedBoard);
            gameResult.addBoard(this.getBoard());
        }
        checkGameResult(gameResult);
        return gameResult;
    }

    private int[][] move(Point position, int[][] board, Point nextPosition) {
        board[position.getX()][position.getY()] -= 4;
        board[nextPosition.getX()][nextPosition.getY()] += 4;
        return board;
    }

    private int[][] pushBall(Point position, int[][] board, Point nextPosition, Command command) {
        board[position.getX()][position.getY()] -= 4;
        board[nextPosition.getX()][nextPosition.getY()] += 4;
        board[nextPosition.getX()][nextPosition.getY()] -= 2;
        board[nextPosition.getX() + command.getNextPosition().get(0)][nextPosition.getY() + command.getNextPosition().get(1)] += 2;
        return board;
    }

    private void checkGameResult(GameResult result) {
        if (result.getBoard() == null) {
            result.addBoard(getBoard());
        }
    }

    private boolean pushable(Point point, Command command) {
        int x = point.getX();
        int y = point.getY();
        int fonrtOfBallX = x + command.getNextPosition().get(0);
        int fonrtOfBallY = y + command.getNextPosition().get(1);
        return (isBall(point) && isBlank(Position.of(fonrtOfBallX, fonrtOfBallY)))
                || (isBall(point) && isHall(Position.of(fonrtOfBallX, fonrtOfBallY)))
                || isBallOnTheHole(point) && isBlank(Position.of(fonrtOfBallX, fonrtOfBallY));
    }

    private boolean isBall(Point point) {
        return this.board[point.getX()][point.getY()] == 2;
    }

    private boolean moveable(Point point) {
        return this.board[point.getX()][point.getY()] == 0 || this.board[point.getX()][point.getY()] == 1;
    }

    private boolean isBlank(Point point) {
        return this.board[point.getX()][point.getY()] == 0;
    }

    private boolean isHall(Point point) {
        return this.board[point.getX()][point.getY()] == 1;
    }

    private boolean isBallOnTheHole(Point point) {
        return this.board[point.getX()][point.getY()] == 3;
    }

    private boolean isPlayer(Point point) {
        return this.board[point.getX()][point.getY()] == 4 || this.board[point.getX()][point.getY()] == 5;
    }

    String[][] getBoard() {
        String[][] copyBoard = new String[this.board.length][this.board[0].length];
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board[0].length; col++) {
                copyBoard[row][col] = changeIntSymbol(this.board[row][col]);
            }
        }
        return copyBoard;
    }

    int[][] copyBoard() {
        int[][] copyBoard = new int[this.board.length][this.board[0].length];
        for (int row = 0; row < this.board.length; row++) {
            copyBoard[row] = this.board[row].clone();
        }
        return copyBoard;
    }

    protected void update(int[][] updatedBoard) {
        this.board = null;
        this.board = updatedBoard;
    }

    protected Point findPlayerPosition() {
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board[0].length; col++) {
                if (isPlayer(Position.of(row, col))) {
                    return Position.of(row, col);
                }
            }
        }
        return null;
    }

    protected boolean isAnswer() {
        return answer.isAnswer(this.board);
    }

    protected boolean checkAnswer(String[][] arry) {
        return answer.isAnswer(changeStringArrayToIntArrayUsingSymbol(arry));
    }

    protected void reset() {
        int[][] reset = this.answer.getOriginal();
        update(reset);
    }
}
