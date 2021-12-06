import java.util.List;

public class OutputView {

    private final StringBuilder stringBuilder = new StringBuilder();

    private void printBoard(GameResult result) {
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

    public void print(List<StageResult> results) {
        stringBuilder.setLength(0);
        for (int number = 0; number < results.size(); number++) {
            StageResult stageInfo = results.get(number);
            stringBuilder.append(Message.STAGE_INFO).append(stageInfo.getStage()).append("\n");
            String[][] stageMap = getStringArray(results.get(number).getMap());
            for (int row = 0; row < stageInfo.getMap().length; row++) {
                stringBuilder.append("\n");
                for (int col = 0; col < stageInfo.getMap()[0].length; col++) {
                    stringBuilder.append(stageMap[row][col]);
                }
            }
            stringBuilder.append("\n").append("\n").append(Message.HORIZONTAL_LENGTH).append(stageInfo.getHorizontalCount()).append("\n")
                    .append(Message.VERTICAL_LENGTH).append(stageInfo.getVerticalCount()).append("\n")
                    .append(Message.HOLE_COUNT).append(stageInfo.getHoleCount()).append("\n")
                    .append(Message.BALL_COUNT).append(stageInfo.getBallCount()).append("\n")
                    .append(Message.PLAYER_POSITION).append(stageInfo.getPlayerPosition()).append("\n").append("\n");
        }
        System.out.println(stringBuilder);
    }

    private String[][] getStringArray(int[][] map) {
        String[][] stringArray = new String[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                stringArray[i][j] = getStringValue(map[i][j]);
            }
        }
        return stringArray;
    }

    private String getStringValue(int symbol) {
        if (symbol == 0) {
            return "#";
        }
        if (symbol == 1) {
            return "O";
        }
        if (symbol == 2) {
            return "o";
        }
        if (symbol == 3) {
            return "P";
        }
        if (symbol == 5) {
            return " ";
        }
        return " ";
    }
}
