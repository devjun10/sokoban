public class Board {

    private int id;
    private final int BOARD_START = 0;
    private final int BOARD_HEIGHT = 7;
    private final int BOARD_WIDTH = 11;
    private int[][] board;
    private Answer answer = new Answer(this.board);


    private Board() {
        initBoard();
    }


    void initBoard() {

    }

    static Board of() {
        return new Board();
    }


    void init() {
        this.board = null;
        this.board = this.answer.getAnswer();
    }

    void push(Pair pair) {

    }

    String[][] getBoard() {
        String[][] copyBoard = new String[this.board[0].length][this.board.length];
        for (int row = BOARD_START; row < this.board.length; row++) {
            for (int col = BOARD_START; col < this.board[0].length; col++) {
                copyBoard[row][col] = changeIntSymbol(this.board[row][col]);
            }
        }
        return copyBoard;
    }

    protected void update(int[][] updatedBoard) {
        this.board = null;
        this.board = updatedBoard;
    }

    protected Pair findPlayerPosition() {
        for (int row = 0; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                if (this.board[row][col] == 4 || this.board[row][col] == 5) {
                    return Pairs.of(row, col);
                }
            }
        }
        return null;
    }

    protected boolean validatePosition(Pair pair) {
        if (!validateRange(pair)) {
            return false;
        }
        if (!validateMoveable(pair)) {
            return false;
        }
        return true;
    }

    private boolean validateRange(Pair pair) {
        return pair.getX() >= 0 && pair.getX() < 7 && pair.getY() >= 0 && pair.getY() < 11;
    }

    private boolean validateMoveable(Pair pair) {
        return this.board[pair.getX()][pair.getY()] == 9 && this.board[pair.getX()][pair.getY()] == 1;
    }

    public static String changeSymbol(String word) {
        word = word.replaceAll("9", "#");
        word = word.replaceAll("0", " ");
        word = word.replaceAll("1", "O");
        word = word.replaceAll("2", "o");
        word = word.replaceAll("3", "0");
        word = word.replaceAll("4", "P");
        word = word.replaceAll("5", "P");
        return word;
    }

    public static String changeIntSymbol(int value) {
        if (value == 5) return "P";
        if (value == 0) return " ";
        if (value == 1) return "O";
        if (value == 2) return "o";
        if (value == 3) return "0";
        if (value == 4) return "P";
        return "#";
    }
}
