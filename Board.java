public class Board {

    private int id;
    private int BOARD_WIDTH;
    private int BOARD_HEIGHT;

    private int[][] board;
    private Answer answer;

    private Board() {
        initBoard();
    }

    void initBoard() {
        this.board = new int[6][6];
        this.board[0] = new int[]{9, 9, 9, 9, 9, 9};
        this.board[1] = new int[]{9, 0, 0, 4, 0, 9};
        this.board[2] = new int[]{9, 2, 9, 9, 9, 9};
        this.board[3] = new int[]{9, 0, 9, 0, 0, 0};
        this.board[4] = new int[]{9, 1, 9, 0, 0, 0};
        this.board[5] = new int[]{9, 9, 9, 0, 0, 0};

        this.BOARD_WIDTH = board[0].length;
        this.BOARD_HEIGHT = board.length;

        this.answer = new Answer(copyBoard(this.board));
    }

    public static void main(String[] args) throws Exception {
        Board board = new Board();

        for (int i = 0; i < 6; i++) {
            System.out.println();
            for (int j = 0; j < 6; j++) {
                System.out.print(board.board[i][j]);
            }
        }
        Command command = Command.getDirection("a");
        System.out.println();
        Pair playerPosition = board.findPlayerPosition();

        Command command2 = Command.getDirection("d");
        board.push(playerPosition, command);

        Pair playerPosition2 = board.findPlayerPosition();
        board.push(playerPosition2, command2);

        for (int i = 0; i < 6; i++) {
            System.out.println();
            for (int j = 0; j < 6; j++) {
                System.out.print(board.board[i][j]);
            }
        }


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

    public Answer getAnswer() {
        return answer;
    }

    void init() {
        this.board = null;
        this.board = this.answer.getAnswer();
    }

    void push(Pair pair, Command command) {
        int currentX = pair.getX();
        int currentY = pair.getY();
        int pushBlockX = pair.getX() + command.getNextPosition().get(0);
        int pushBlockY = pair.getY() + command.getNextPosition().get(1);

        if (moveable(Pairs.of(pushBlockX, pushBlockY), command)) {
            System.out.println(11);
            this.board[currentX][currentY] -= 4;
            this.board[pushBlockX + command.getNextPosition().get(0)][pushBlockY + command.getNextPosition().get(1)] += 4;
            update(board);
            return;
        }

        System.out.println("=====");

    }

    public boolean moveable(Pair pair, Command command) {
        int x = pair.getX();
        int y = pair.getY();

        int fonrtOfBallX = x + command.getNextPosition().get(0);
        int fonrtOfBallY = y + command.getNextPosition().get(1);
        return (isBall(x, y) && this.board[fonrtOfBallX][fonrtOfBallY] == 0)
                || (isBall(x, y) && this.board[fonrtOfBallX][fonrtOfBallY] == 1) || this.board[x][y] == 0 || this.board[x][y] == 1;
    }

    public boolean isBall(int x, int y) {
        return this.board[x][y] == 2;
    }

    // 벽을 만났을 대
    public boolean isWall(int x, int y) {
        return this.board[x][y] == 9;
    }

    String[][] getBoard() {
        String[][] copyBoard = new String[this.board[0].length][this.board.length];
        for (int row = BOARD_HEIGHT; row < this.board.length; row++) {
            for (int col = BOARD_WIDTH; col < this.board[0].length; col++) {
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
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board[0].length; col++) {
                if (this.board[row][col] == 4 || this.board[row][col] == 5) {
                    return Pairs.of(row, col);
                }
            }
        }
        return null;
    }

    protected boolean validatePush(Pair pair) {
        if (!validateRange(pair)) {
            return false;
        }
        return true;
    }

    private boolean validateRange(Pair pair) {
        return pair.getX() >= 0 && pair.getX() < BOARD_HEIGHT && pair.getY() >= 0 && pair.getY() < BOARD_WIDTH;
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
