import java.awt.*;
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

    static String joiningTextFileWord() {
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
        return stringBuilder.toString();
    }

    private static String[] splitByStage(String word) {
        return word.split("==========");
    }

    private static String[] splitByComma(String word) {
        return word.split(",");
    }

    public static List<String[][]> getWordArray(String word) {
        List<String[][]> temp = new ArrayList<>();
        List<StageInformation> information = StageInfo.getStages();
        //999999,900409,929999,909000,919000,999000
        String[] stages = splitByComma(word);// 각 스테이지 별로 나뉘어 져 있음
        for (int i = 0; i < stages.length; i++) {
            String each = stages[i];
//            System.out.println(each);

        }

        return temp;
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
        String maps = joiningTextFileWord();
        String[] eachStages = splitByStage(maps);// 스테이지 별로
        List<StageInformation> information = StageInfo.getStages();
        List<String> lst = Arrays.asList(eachStages);
        lst.forEach(System.out::println);

    }
}




