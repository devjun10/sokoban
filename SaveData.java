import java.util.ArrayList;
import java.util.List;

public class SaveData {

    private static List<int[][]> compileData = new ArrayList<>();
    private List<int[][]> rollbackData = new ArrayList<>();

    private SaveData() {
    }

    ;

    public static SaveData of() {
        return new SaveData();
    }

    public int[][] rollBackOneTurn() {
        if (compileData.size() == 1) {
            return compileData.get(0);
        }
        return new int[0][];
    }

    public int[][] cancelRollback() {
        if (compileData.size() == 1) {
            return compileData.get(0);
        }
        return new int[0][];
    }

    public void init(int[][] copyBoard) {
        compileData.add(copyBoard);
    }

    public void resetData() {
        int[][] importantData = copyBoard();
        compileData.clear();
        compileData.add(importantData);
    }

    private int[][] copyBoard() {
        int[][] firstElement = this.rollbackData.get(0);
        int[][] temp = new int[firstElement.length][firstElement[0].length];
        for (int row = 0; row < firstElement.length; row++) {
            temp[row] = firstElement[row].clone();
        }
        return temp;
    }

    public void addAll(List<GameResult> executeResult) {

    }

}
