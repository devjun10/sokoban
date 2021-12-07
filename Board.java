public class Board {

    private int id;
    private final int BOARD_START = 0;
    private final int BOARD_HEIGHT = 7;
    private final int BOARD_WIDTH = 11;

    private String[][] board;

    private Answer answer = new Answer(null);

    private Board() {
        initBoard();
    }

    private boolean validateClear(){
        return answer.checkAnswer(this.board);
    }

    void initBoard() {
        board = new String[BOARD_HEIGHT][BOARD_WIDTH];
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

    void push(Pair pair){

    }

    String[][] getBoard() {
        String[][] copyBoard = new String[BOARD_HEIGHT][BOARD_WIDTH];
        for (int row = BOARD_START; row < BOARD_HEIGHT; row++) {
            copyBoard[row] = this.board[row].clone();
        }
        return copyBoard;
    }

    protected void update(String[][] updatedBoard) {
        this.board = null;
        this.board = updatedBoard;
    }

    protected Pair findPlayerPosition() {
        for (int row = 0; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                if (this.board[row][col].equals("P")) {
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
        return this.board[pair.getX()][pair.getY()].equals(" ");
    }
}
