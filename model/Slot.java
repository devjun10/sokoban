package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import static utils.BoardUtils.changeStringArrayToIntArrayOriginal;
import static utils.BoardUtils.changeStringArrayToIntArrayUsingSymbol;
import static utils.Parser.*;


public class Slot {

    private final StringBuilder stringBuilder = new StringBuilder();
    private final String empty = "Empty";
    private final String slot = "slot";
    private final String line = "==========";
    private final String txt = ".txt";
    private final String blank = "";
    private final String directory = "slot/";
    private final int minLine = 2;
    private List<StageData> saveData = new ArrayList<>();
    private List<StageData> checkData;

    private Slot() {
        for (int i = 1; i < 5; i++) {
            saveData.add(new StageData(i, empty));
        }
        List<StageData> temp = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            temp.add(new StageData(i, "Stage" + i));
        }
        this.checkData = Collections.unmodifiableList(temp);
    }

    public static Slot of() {
        return new Slot();
    }

    void saveData(int stageNumber, String[][] array) {
        validateStageNumber(stageNumber);
        stringBuilder.setLength(0);
        String name = slot + stageNumber + txt;
        File file = new File(name);
        int[][] intArray = changeStringArrayToIntArrayUsingSymbol(array);
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

    List<StageData> getSlotData() {
        for (int i = 0; i < this.saveData.size(); i++) {
            if (loadStageData(i + 1).length > minLine) {
                saveData.get(i).editName(checkData.get(i).getName());
            }
        }
        return new ArrayList<>(saveData.stream()
                .collect(Collectors.toUnmodifiableList()));
    }

    private boolean validateStageNumber(int stageNumber) {
        if (stageNumber <= 0 || stageNumber > 5) {
            return false;
        }
        return true;
    }

    public int[][] loadSaveData(int stageNumber) {
        return changeStringArrayToIntArrayOriginal(loadStageData(stageNumber));
    }

    private String[][] loadStageData(int stageNumber) {
        String[] mapData = joiningTextFileWord(stageNumber);
        String[][] temp = new String[mapData.length][mapData[0].length()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = mapData[i].split(blank);
        }
        return temp;
    }

    String[] joiningTextFileWord(int stageNumber) {
        String fileName = directory + slot + stageNumber + txt;
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
        return splitByComma(replaceBar(stringBuilder.toString()));
    }

}
