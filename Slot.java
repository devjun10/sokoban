import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Slot {

    private final StringBuilder stringBuilder = new StringBuilder();
    private final String save = "save";
    private final String line = "==========";
    private final String txt = ".txt";
    private List<StageData> saveData = new ArrayList<>();

    private Slot() {};

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

    public int[][] loadSaveData(int stageNumber){
        return changeStringArrayToIntArrayOriginal(loadStageData(stageNumber));
    }

    private String[][] loadStageData(int stageNumber) {
        String[] mapData = joiningTextFileWord(stageNumber);
        String[][] temp = new String[mapData.length][mapData[0].length()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = mapData[i].split("");
        }
        return temp;
    }

    String[] joiningTextFileWord(int stageNumber) {
        String fileName = save + stageNumber + txt;
        try {
            stringBuilder.setLength(0);
            File file = new File(fileName);
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while ((line = bufReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            bufReader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println(stringBuilder);
        return splitByComma(replaceBar(stringBuilder.toString()));
    }

    private String[] splitByComma(String word) {
        return word.split(",");
    }

    private String replaceBar(String word) {
        return word.replace("==========", "");
    }

    private int[][] changeStringArrayToIntArray(String[][] array) {
        int[][] temp = new int[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                temp[row][col] = changeStringSymbol(array[row][col]);
            }
        }
        return temp;
    }

    private int[][] changeStringArrayToIntArrayOriginal(String[][] array) {
        int[][] temp = new int[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                temp[row][col] = Integer.parseInt(array[row][col]);
            }
        }
        return temp;
    }

    private static int changeStringSymbol(String value) {
        if (value.equals("P")) return 4;
        if (value.equals(" ")) return 0;
        if (value.equals("O")) return 1;
        if (value.equals("o")) return 2;
        if (value.equals("0")) return 3;
        if (value.equals("#")) return 9;
        return 0;
    }
}
