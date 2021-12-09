package view;

public class GameResult {

    private String[][] board;
    private String message;

    public GameResult (){};

    public GameResult(String[][] board) {
        this.board = board;
    }

    public GameResult(String message) {
        this.message = message;
    }

    public GameResult(String[][] board, String message) {
        this.board = board;
        this.message = message;
    }

    public String[][] getBoard() {
        return board;
    }

    public String getMessage() {
        return message;
    }

    public void addBoard(String[][] board) {
        this.board = board;
    }

    public void addMesage(String message) {
        this.message = message;
    }
}
