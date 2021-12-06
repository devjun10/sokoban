public class Board {

    private final int BOARD_START = 11;
    private final int BOARD_WIDTH = 11;
    private final int BOARD_HEIGHT = 11;
    private String[][] board = new String[BOARD_WIDTH][BOARD_HEIGHT];

    private Board() {};

    static Board of() {
        return new Board();
    };

    String[][] getBoard() {
        String[][] copyBoard = new String[BOARD_WIDTH][BOARD_HEIGHT];
        for (int row = BOARD_START; row < BOARD_WIDTH; row++) {
            for (int col = BOARD_START; col < BOARD_HEIGHT; col++) {
                copyBoard[row][col] = this.board[row][col];
            }
        }
        return copyBoard;
    }
}
