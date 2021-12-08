import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Slot {

    private final StringBuilder stringBuilder = new StringBuilder();
    private final String save = "save";
    private final String line = "==========";
    private final String txt = ".txt";
    private List<StageData> saveData = new ArrayList<>();

    private Slot() {
    }

    ;

    public static Slot of() {
        return new Slot();
    }

    public void saveData(int stageNumber, String[][] array) {
        stringBuilder.setLength(0);
        String name = save + stageNumber + txt;
        File file = new File(name);
        int[][] intArray = changeStringArrayToIntArray(array);
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                stringBuilder.append(intArray[row][col]).append("");
            }
            stringBuilder.append(",").append("\n");
        }
        stringBuilder.append(line);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(stringBuilder.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        Slot slot = new Slot();
        String[][] arra = new String[6][6];

    }

    public StageData loadStageData(int stageNumber) {
        return this.saveData.stream()
                .filter(stage -> stage.getStage() == stageNumber)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    private int[][] changeStringArrayToIntArray(String[][] array) {
        System.out.println(array[0][0]);
        int[][] temp = new int[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
//                System.out.println(array[row][col]);
                temp[row][col] = changeStringSymbol(array[row][col]);
            }
        }
        return temp;
    }

    private static int changeStringSymbol(String value) {
        if (value.equals("P")) return 0;
        if (value.equals(" ")) return 0;
        if (value.equals("O")) return 1;
        if (value.equals("o")) return 2;
        if (value.equals("0")) return 3;
        if (value.equals("#")) return 9;
        return 0;
    }

    int[][] copyBoard(int[][] array) {
        int[][] temp = new int[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            temp[row] = array[row].clone();
        }
        return temp;
    }
}
