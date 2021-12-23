package model;

import utils.Number;
import utils.Point;
import utils.Position;
import view.GameResult;
import view.commands.DirectionCommand;

import static utils.BoardUtils.*;
import static utils.Number.*;

public class Board {

    private int[][] board;

    private Answer answer;

    private Board() {};

    Board(int[][] board) {
        this.board = board;
        this.answer = new Answer(board);
    }

    GameResult push(DirectionCommand command) {
        GameResult gameResult = new GameResult();
        Point currentPosition = findPlayerPosition();

        int nextX = getNextPositionX(currentPosition, command);
        int nextY = getNextPositionY(currentPosition, command);
        int[][] board = copyIntArrayOriginal(this.board);
        Point nextPosition = Position.of(nextX, nextY);

        moveSymbol(currentPosition, board, nextPosition, command);
        addGameResult(gameResult);
        return gameResult;
    }

    private int getNextPositionX(Point currentPosition, DirectionCommand command) {
        return currentPosition.getX() + command.getNextPosition().getX();
    }

    private int getNextPositionY(Point currentPosition, DirectionCommand command) {
        return currentPosition.getY() + command.getNextPosition().getY();
    }

    private void moveSymbol(Point currentPosition, int[][] board, Point nextPosition, DirectionCommand command) {
        if (moveable(nextPosition)) {
            int[][] updatedBoard = moveCharacter(currentPosition, board, nextPosition);
            update(updatedBoard);
        } else if (pushable(nextPosition, command)) {
            int[][] updatedBoard = pushBall(currentPosition, board, nextPosition, command);
            update(updatedBoard);
        }
    }

    private int[][] moveCharacter(Point currentPosition, int[][] board, Point nextPosition) {
        board[currentPosition.getX()][currentPosition.getY()] -= FOUR.getIntvalue();
        board[nextPosition.getX()][nextPosition.getY()] += FOUR.getIntvalue();
        return board;
    }

    private int[][] pushBall(Point currentPosition, int[][] board, Point nextPosition, DirectionCommand command) {
        board[currentPosition.getX()][currentPosition.getY()] -= FOUR.getIntvalue();
        board[nextPosition.getX()][nextPosition.getY()] += FOUR.getIntvalue();
        board[nextPosition.getX()][nextPosition.getY()] -= TWO.getIntvalue();
        board[nextPosition.getX() + command.getNextPosition().getX()][nextPosition.getY() + command.getNextPosition().getY()] += Number.TWO.getIntvalue();
        return board;
    }

    private void addGameResult(GameResult result) {
        result.addBoard(getStringBoard());
    }

    private boolean pushable(Point nextPosition, DirectionCommand command) {
        int nextPositionX = nextPosition.getX();
        int nextPositionY = nextPosition.getY();

        int inFrontOfBallX = nextPositionX + command.getNextPosition().getX();
        int inFrontOfBallY = nextPositionY + command.getNextPosition().getY();
        Point inFrontOfBall = Position.of(inFrontOfBallX, inFrontOfBallY);

        return (isBall(nextPosition) && isBlank(inFrontOfBall))
                    || (isBall(nextPosition) && isHall(inFrontOfBall))
                    || (isBallOnTheHole(nextPosition) && isBlank(inFrontOfBall));
    }

    private boolean isBall(Point point) {
        int nextBlank = this.board[point.getX()][point.getY()];
        return nextBlank == TWO.getIntvalue();
    }

    private boolean moveable(Point point) {
        int nextPositionX = this.board[point.getX()][point.getY()];
        int nextPositionY = this.board[point.getX()][point.getY()];
        return nextPositionX == ZERO.getIntvalue() || nextPositionY == ONE.getIntvalue();
    }

    private boolean isBlank(Point point) {
        int nextBlank = this.board[point.getX()][point.getY()];
        return nextBlank == ZERO.getIntvalue();
    }

    private boolean isHall(Point point) {
        int nextBlank = this.board[point.getX()][point.getY()];
        return nextBlank == ONE.getIntvalue();
    }

    private boolean isBallOnTheHole(Point point) {
        int nextBlank = this.board[point.getX()][point.getY()];
        return nextBlank == THREE.getIntvalue();
    }

    private boolean isPlayer(Point point) {
        int nextBlankPositionX = this.board[point.getX()][point.getY()];
        int nextBlankPositionY = this.board[point.getX()][point.getY()];
        return nextBlankPositionX == FOUR.getIntvalue() || nextBlankPositionY == FIVE.getIntvalue();
    }

    String[][] getStringBoard() {
        return convertIntArrayToStringArrayUsingSymbol(this.board);
    }

    int[][] getIntBoard() {
        return copyIntArrayOriginal(this.board);
    }

    protected void update(int[][] updatedBoard) {
        this.board = null;
        this.board = updatedBoard;
    }

    private Point findPlayerPosition() {
        Point playerPosition = null;
        Point currentPosition = null;
        for (int x = 0; x < this.board.length; x++) {
            for (int y = 0; y < this.board[0].length; y++) {
                currentPosition = getPlayerPosition(Position.of(x, y));
                playerPosition = findPlayer(playerPosition, currentPosition);

            }
        }
        return playerPosition;
    }

    private Point getPlayerPosition(Point point) {
        if (isPlayer(point)) {
            return point;
        }
        return Position.of(ZERO.getIntvalue(), ZERO.getIntvalue());
    }

    private Point findPlayer(Point playerPosition, Point position) {
        if (isPlayer(position)) {
            return position;
        }
        return playerPosition;
    }

    protected boolean isAnswer() {
        return answer.isAnswer(this.board);
    }

    protected boolean checkAnswer(String[][] arry) {
        return answer.isAnswer(convertStringArrayToIntArrayUsingSymbol(arry));
    }

    void reset() {
        int[][] reset = this.answer.getOriginalBoard();
        update(reset);
    }
}
