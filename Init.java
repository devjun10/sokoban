import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Init {

    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final StageInfo stageInfo = StageInfo.of();
    private static final Boards boards = Boards.of();

    static {
        List<StageInformation> information = stageInfo.getStageInformation();
        List<String[][]> maps = getMaps();
        for (int i = 0; i < 4; i++) {
            Board board = new Board(changeStringArrayToIntegerArray(maps.get(i)));
//            for(int p=0; p<board.getBoard().length; p++){
//                System.out.println();
//                for(int j=0; j<board.getBoard()[0].length; j++){
//                    System.out.print(board.getBoard()[p][j]);
//                }
//            }
            StageInformation info = information.get(i);
            Stages.putStage(i + 1, info, board);
        }
    }

    private static int[][] changeStringArrayToIntegerArray(String[][] array) {
        int[][] temp = new int[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                temp[row][col] = Integer.parseInt(array[row][col]);
            }
        }
        return temp;
    }

    private Init() {};

    public static Init of() {
        return new Init();
    }

    List<StageInformation> getStageInformation() {
        return stageInfo.getStageInformation();
    }

    List<Board> getBoards() {
        return List.of();
    }

    public static List<String[][]> getMaps() {
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

}




