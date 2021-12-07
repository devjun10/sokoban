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

    public static void main(String[] args) {
        Board board = new Board();

        //1
        Command command = Command.getDirection("a");
        Pair playerPosition = board.findPlayerPosition();
        board.push(playerPosition, command);

        for (int i = 0; i < 6; i++) {
            System.out.println();
            for (int j = 0; j < 6; j++) {
                System.out.print(board.board[i][j]);
            }
        }
        System.out.println();

        //2
        Command commandSecond = Command.getDirection("a");
        Pair movedPlayer = board.findPlayerPosition();
        board.push(movedPlayer, commandSecond);
        System.out.println("------------------");

        //3
        Command commandSecond3 = Command.getDirection("s");
        Pair movedPlayer3 = board.findPlayerPosition();
        System.out.println("=============");
        System.out.println(movedPlayer3+", ");
        System.out.println("=============");
        board.push(movedPlayer3, commandSecond3);

        Command commandSecond4 = Command.getDirection("s");
        Pair movedPlayer4 = board.findPlayerPosition();
        System.out.println(movedPlayer3+", ");
        board.push(movedPlayer4, commandSecond4);
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
        int moveBlockX = pair.getX() + command.getNextPosition().get(0);
        int moveBlockY = pair.getY() + command.getNextPosition().get(1);
        int[][] newBoard = copyBoard();

        if (moveable(Pairs.of(moveBlockX, moveBlockY))) {
            newBoard[pair.getX()][pair.getY()] -= 4;
            newBoard[moveBlockX][moveBlockY] += 4;
            update(newBoard);
        } else if (pushable(Pairs.of(moveBlockX, moveBlockY), command)) {
            newBoard[pair.getX()][pair.getY()] -= 4;
            newBoard[moveBlockX][moveBlockY] += 4;
            newBoard[moveBlockX][moveBlockY] -= 2;
            newBoard[moveBlockX + command.getNextPosition().get(0)][moveBlockY + command.getNextPosition().get(1)] += 2;
            update(newBoard);
        }
//        return new GameResult(this.getBoard());
    }

    public boolean pushable(Pair pair, Command command) {
        // 다음 항
        int x = pair.getX();
        int y = pair.getY();
        int fonrtOfBallX = x + command.getNextPosition().get(0);
        int fonrtOfBallY = y + command.getNextPosition().get(1);
        return (isBall(x, y) && isBlank(fonrtOfBallX, fonrtOfBallY)) || (isBall(x, y) && isHall(fonrtOfBallX, fonrtOfBallY));
    }

    public boolean moveable(Pair pair) {
        return this.board[pair.getX()][pair.getY()] == 0 || this.board[pair.getX()][pair.getY()] == 1;
    }

    public boolean isBlank(int x, int y){
        return this.board[x][y] == 0;
    }

    public boolean isHall(int x, int y){
        return this.board[x][y] == 1;
    }

    public boolean isBall(int x, int y) {
        return this.board[x][y] == 2;
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
