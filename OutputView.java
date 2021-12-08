import java.util.List;

public class OutputView {

    private final StringBuilder stringBuilder = new StringBuilder();

    public void printInitStage(String[][] board) {
        stringBuilder.setLength(0);

        for (int row = 0; row < board.length; row++) {
            if (row != 0) {
                stringBuilder.append("\n");
            }
            for (int col = 0; col < board[0].length; col++) {
                stringBuilder.append(board[row][col]);
            }
        }
        stringBuilder.append("\n");
        System.out.println(stringBuilder);
    }

    public void printBoard(GameResult result) {
        stringBuilder.setLength(0);
        String[][] board = result.getBoard();
        for (int row = 0; row < board.length; row++) {
            if (row != 0) {
                stringBuilder.append("\n");
            }
            for (int col = 0; col < board[0].length; col++) {
                stringBuilder.append(board[row][col]);
            }
        }
        stringBuilder.append("\n");
        System.out.println(stringBuilder);
    }

    public void printResult(List<GameResult> results) {
        for (GameResult result : results) {
            printBoard(result);
            System.out.println();
        }
    }
}
