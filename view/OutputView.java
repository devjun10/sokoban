package view;

import utils.Number;

import static utils.InputUtils.stringBuilder;

public class OutputView {

    public void printBoard(String[][] board) {
        stringBuilder.setLength(Number.ZERO.getIntvalue());

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

    public void printGameResult(GameResult result) {
        stringBuilder.setLength(Number.ZERO.getIntvalue());
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
}
