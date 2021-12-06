public class Board {

    private final int BOARD_START = 0;
    private final int BOARD_WIDTH = 11;
    private final int BOARD_HEIGHT = 11;
    private String[][] board;

    private Board() {
        initBoard();
    }

    void initBoard() {
        board = new String[BOARD_WIDTH][BOARD_HEIGHT];
        this.board[0] = new String[]{" ", " ", "#", "#", "#", "#", "#", "#", "#", " ", " "};
        this.board[1] = new String[]{"#", "#", "#", " ", " ", "O", " ", " ", "#", "#", "#"};
        this.board[2] = new String[]{"#", " ", " ", " ", " ", "o", " ", " ", " ", " ", "#"};
        this.board[3] = new String[]{"#", " ", "O", "o", " ", "P", " ", "o", "O", " ", "#"};
        this.board[4] = new String[]{"#", "#", "#", " ", " ", "o", " ", " ", "#", "#", "#"};
        this.board[5] = new String[]{" ", "#", " ", " ", " ", "O", " ", " ", "#", " ", " "};
        this.board[6] = new String[]{" ", "#", "#", "#", "#", "#", "#", "#", "#", " ", " "};
    }

    static Board of() {
        return new Board();
    }

    ;

    String[][] getBoard() {
        String[][] copyBoard = new String[BOARD_WIDTH][BOARD_HEIGHT];
        for (int row = BOARD_START; row < BOARD_WIDTH; row++) {
            copyBoard[row] = this.board[row].clone();
        }
        return copyBoard;
    }

    protected void update(String[][] updatedBoard) {
        this.board = null;
        this.board = updatedBoard;
    }

    protected Pair findPlayerPosition() {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;

        for (int row = 0; row < 11; row++) {
            for (int col = 0; col < 11; col++) {
                if (board[row][col].equals("P")) {
                    x = row;
                    y = col;
                }
            }
        }
        return Pairs.of(x, y);
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
        return pair.getX() >= 0 && pair.getY() < 11 && pair.getY() >= 0 && pair.getY() < 11;
    }

    private boolean validateMoveable(Pair pair) {
        return this.board[pair.getX()][pair.getY()].equals(" ")
                || this.board[pair.getX()][pair.getY()].equals("O");
    }

}
