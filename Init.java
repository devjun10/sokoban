import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Init {

    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final StageInfo stageInfo = StageInfo.of();
    private static final Boards boards = Boards.of();

    static {
        List<StageInformation> information = stageInfo.getStageInformation();
        List<Board> boards = null;

        for (int i = 0; i < 4; i++) {

        }
    }

    List<StageInformation> getStageInformation() {
        return stageInfo.getStageInformation();
    }

    List<Board> getBoards() {
        return List.of();
    }

    static void initBoard() {
        List<Board> boards = new ArrayList<>();
    }

    public static List<String[][]> getMaps(){
        String[][] result = getStages();
        List<String[][]> answer = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            String[] temp = result[i];
            String[][] array = new String[temp.length][temp[0].length()];
            for(int j=0; j<temp.length; j++){
                array[j] = temp[j].split("");
            }
            answer.add(array);
        }
        return answer;
    }

    public static String[][] getStages() {
        String[] eachStages = joiningTextFileWord();
        int rows = eachStages.length;
        String[][] result = new String[rows][];

        for (int i = 0; i < rows; i++) {
            String[] temp = eachStages[i].split(",");
            int tempCols = temp.length;
            result[i] = new String[tempCols];
            for (int j = 0; j < tempCols; j++) {
                result[i][j] = temp[j];
            }
        }
        return result;
    }

    static String[] joiningTextFileWord() {
        try {
            stringBuilder.setLength(0);
            File file = new File("map.txt");
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
        return splitByStage(stringBuilder.toString());
    }

    private static String[] splitByStage(String word) {
        return word.split("==========");
    }

    private static String[] splitByComma(String word) {
        return word.split(",");
    }



    public static String changeSymbol(String word) {
        word = word.replaceAll("9", "#");
        word = word.replaceAll("0", " ");
        word = word.replaceAll("1", "O");
        word = word.replaceAll("2", "o");
        word = word.replaceAll("3", "0");
        word = word.replaceAll("4", "P");
        word = word.replaceAll("5", "P");
        return word;
    }

    public static void main(String[] args) throws Exception {
        String[] eachStages = joiningTextFileWord();// 스테이지 별로
        int rows = eachStages.length;
        String[][] result = new String[rows][];

        for (int i = 0; i < rows; i++) {
            String[] temp = eachStages[i].split(",");
            int tempCols = temp.length;
            result[i] = new String[tempCols];
            for (int j = 0; j < tempCols; j++) {
                result[i][j] = temp[j];
            }
        }

        List<String[][]> answer = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            String[] temp = result[i];
            String[][] array = new String[temp.length][temp[0].length()];
            for(int j=0; j<temp.length; j++){
                array[j] = temp[j].split("");
            }
            answer.add(array);
        }
        System.out.println("==============");
        String[][] test = getMaps().get(0);
        for(int row=0; row<test.length; row++){
            System.out.println();
            for(int col=0 ; col<test[0].length; col++){
                System.out.print(test[row][col]);
            }
        }


    }
}




