package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static utils.BoardUtils.convertStringArrayToIntArrayOriginal;
import static utils.Parser.splitByComma;
import static utils.Parser.splitByStage;

public class Init {

    private static final String mapFile = "map/map_enc.txt";
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final StageInformationList stageInformationList = StageInformationList.of();
    private AES256Cipher aes256Cipher = model.AES256Cipher.getInstance();

    {
        List<StageInformation> information = stageInformationList.getStageInformation();
        List<String[][]> maps = null;
        try {
            maps = getMaps();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 4; i++) {
            Board board = new Board(convertStringArrayToIntArrayOriginal(maps.get(i)));
            StageInformation info = information.get(i);
            Stages.putStage(i + 1, info, board);
        }
    }

    private Init() {};

    static Init of() {
        return new Init();
    }

    List<String[][]> getMaps() throws Exception {
        String[][] result = getStages();
        List<String[][]> answer = new ArrayList<>();

        for (int i = 0; i < result.length; i++) {
            String[] temp = result[i];
            String[][] array = new String[temp.length][temp[0].length()];
            for (int j = 0; j < temp.length; j++) {
                array[j] = temp[j].split("");
            }
            answer.add(array);
        }
        return answer;
    }

    String[][] getStages() throws Exception {
        String[] eachStages = joiningTextFileWord();
        int rows = eachStages.length;
        String[][] result = new String[rows][];

        for (int i = 0; i < rows; i++) {
            String[] temp = splitByComma(eachStages[i]);
            int tempCols = temp.length;
            result[i] = new String[tempCols];
            for (int j = 0; j < tempCols; j++) {
                result[i][j] = temp[j];
            }
        }
        return result;
    }

    String[] joiningTextFileWord() throws Exception {
        try {
            stringBuilder.setLength(0);
            File file = new File(mapFile);
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
        return splitByStage(AES256Cipher.AES_Decode(stringBuilder.toString()));
    }
}