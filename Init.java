import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Init {

    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final StageInfo stageInfo = StageInfo.of();

    static {

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

    public static List<String[][]> getMap(String[] word) {
        List<String[][]> lst = new ArrayList<>();
        List<StageInformation> information = stageInfo.getStageInformation();
//        StageInformation info = stageInfo.getInformation(1);
        for (int row = 0; row < word.length; row++) {
            StageInformation info = information.get(row);
            System.out.println(info);
            String temp = word[row];
            temp = changeSymbol(temp);
            String[][] a = getWordAsList(temp, info.getHeight(), info.getWidth());
            lst.add(a);
            for (int f = 0; f < info.getHeight(); f++) {
                System.out.println();
                for (int col = 0; col < info.getWidth(); col++) {
                    System.out.print(a[f][col]);
                }
            }
        }
        return lst;
    }

    public static String[][] getWordAsList(String word, int height, int width) {
        String[][] temp = new String[height][width];
        List<String> lst = new ArrayList<>();
        System.out.println(word);

        for(int row=0 ; row<height; row++) {
            for (int i = 0; i < word.length(); i++) {
                temp[row][word.length() % width] = String.valueOf(word.charAt(i));
            }
        }
        for(int row=0; row<height; row++){
            System.out.println();
            for(int col=0; col<width; col++){
                System.out.print(temp[row][col]);
            }
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
        String[] a = joiningTextFileWord();
        getMap(a);
        System.out.println(getMap(a).size());
    }
}


