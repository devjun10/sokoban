public class Board {

    private final int BOARD_START = 0;
    private final int BOARD_WIDTH = 11;
    private final int BOARD_HEIGHT = 11;
    private String[][] board;

    private Board() {
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
    };

    String[][] getBoard() {
        String[][] copyBoard = new String[BOARD_WIDTH][BOARD_HEIGHT];
        for (int row = BOARD_START; row < BOARD_WIDTH; row++) {
            copyBoard[row] = this.board[row].clone();
        }
        return copyBoard;
    }
}
