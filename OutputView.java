import java.util.List;

public class OutputView {

    void print(List<StageResult> results) {
        String[][] stageFirst = getStringArray(results.get(0).getMap());
//        String [][] stageSecond
        for(int i=0; i<3; i++){
            System.out.println();
            for(int col=0; col<5; col++){
                System.out.print(stageFirst[i][col]);
            }
        }
    }

    private String[][] getStringArray(int[][] map) {
        String[][] stringArray = new String[3][5];
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
        if (symbol == 4) {
            return "P";
        }
        return " ";
    }
}
