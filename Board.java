public class Board {

    private int[][] board;

    private Answer answer;

    private Board() {};

    public Board(int[][] board) {
        this.board = board;
        this.answer = new Answer(board);
    }

    static Board of() {
        return new Board();
    }

    int[][] copyBoard(int[][] array) {
        int[][] temp = new int[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            temp[row] = array[row].clone();
        }
        return temp;
    }

    GameResult push(Command command) {
        GameResult gameResult = new GameResult();
        Pair pair = findPlayerPosition();

        int moveBlockX = pair.getX() + command.getNextPosition().get(0);
        int moveBlockY = pair.getY() + command.getNextPosition().get(1);
        int[][] newBoard = copyBoard();

        if (moveable(Pairs.of(moveBlockX, moveBlockY))) {
            int[][] updatedBoard = move(pair, newBoard, Pairs.of(moveBlockX, moveBlockY));
            update(updatedBoard);
            gameResult.addBoard(this.getBoard());
        } else if (pushable(Pairs.of(moveBlockX, moveBlockY), command)) {
            int[][] updatedBoard = pushBall(pair, newBoard, Pairs.of(moveBlockX, moveBlockY), command);
            update(updatedBoard);
            gameResult.addBoard(this.getBoard());
        }
        checkGameResult(gameResult);
        return gameResult;
    }

    private int[][] move(Pair position, int[][] board, Pair nextPosition) {
        board[position.getX()][position.getY()] -= 4;
        board[nextPosition.getX()][nextPosition.getY()] += 4;
        return board;
    }

    private int[][] pushBall(Pair position, int[][] board, Pair nextPosition, Command command) {
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

    private boolean pushable(Pair pair, Command command) {
        // 다음 항
        int x = pair.getX();
        int y = pair.getY();
        int fonrtOfBallX = x + command.getNextPosition().get(0);
        int fonrtOfBallY = y + command.getNextPosition().get(1);
        return (isBall(x, y) && isBlank(fonrtOfBallX, fonrtOfBallY))
                || (isBall(x, y) && isHall(fonrtOfBallX, fonrtOfBallY))
                || isBallOnTheHole(x, y) && isBlank(fonrtOfBallX, fonrtOfBallY);
    }

    private boolean isBall(int x, int y) {
        return this.board[x][y] == 2;
    }

    private boolean moveable(Pair pair) {
        return this.board[pair.getX()][pair.getY()] == 0 || this.board[pair.getX()][pair.getY()] == 1;
    }

    private boolean isBlank(int x, int y) {
        return this.board[x][y] == 0;
    }

    private boolean isHall(int x, int y) {
        return this.board[x][y] == 1;
    }

    private boolean isBallOnTheHole(int x, int y) {
        return this.board[x][y] == 3;
    }

    private boolean isPlayer(int x, int y) {
        return this.board[x][y] == 4 || this.board[x][y] == 5;
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

    private String changeIntSymbol(int value) {
        if (value == 5) return "P";
        if (value == 0) return " ";
        if (value == 1) return "O";
        if (value == 2) return "o";
        if (value == 3) return "0";
        if (value == 4) return "P";
        return "#";
    }

    private int changeStringSymbol(String value) {
        if (value.equals("P")) return 0;
        if (value.equals(" ")) return 0;
        if (value.equals("O")) return 1;
        if (value.equals("o")) return 2;
        if (value.equals("0")) return 3;
        if (value.equals("#")) return 9;
        return 0;
    }

    private void update(int[][] updatedBoard) {
        this.board = null;
        this.board = updatedBoard;
    }

    protected Pair findPlayerPosition() {
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board[0].length; col++) {
                if (isPlayer(row, col)) {
                    return Pairs.of(row, col);
                }
            }
        }
        return null;
    }

    protected boolean isAnswer() {
        return answer.isAnswer(this.board);
    }

    protected boolean checkAnswer(String[][] arry) {
        int[][] temp = changeStringArrayToIntArray(arry);
        return answer.isAnswer(temp);
    }

    protected void reset() {
        int[][] reset = this.answer.getOriginal();
        update(reset);
    }

    private int[][] changeStringArrayToIntArray(String[][] array) {
        int[][] temp = new int[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                temp[row][col] = changeStringSymbol(array[row][col]);
            }
        }
        return temp;
    }
}
