import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Init {
    private static final StringBuilder stringBuilder = new StringBuilder();
    private final static StageInfo stageInfo = StageInfo.of();

    static {

    }

    static void initBoard() {
        List<Board> boards = new ArrayList<>();

    }

    private String[] splitByStage(String word){
        return word.split("==========");
    }

    public static String[][] getMap(String[] word){
        StageInformation info = new StageInformation(1,6, 6);
        String[][] stringArray = new String[info.getHeight()][info.getWidth()];
        for(int row=0; row<word.length; row++){
            String temp = changeSymbol(word[row]);
            for(int col=0; col<temp.length(); col++){
                stringArray[row][col] = String.valueOf(temp.charAt(col));
            }
        }
        return stringArray;
    }

    public static String changeSymbol(String word){
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
        String word = "999999\n900409\n929999\n909000\n919000\n999000";
        String[][] map = getMap(word.split("\n"));
        for(int row=0; row<6; row++){
            System.out.println();
            for(int col=0; col<6; col++){
                System.out.print(map[row][col]);
            }
        }

//        word = word.replaceAll("9", "#");
//        word = word.replaceAll("0", " ");
//        word = word.replaceAll("1", "O");
//        word = word.replaceAll("2", "o");
//        word = word.replaceAll("3", "0");
//        word = word.replaceAll("4", "P");
//        word = word.replaceAll("5", "P");
//        System.out.println(word);

    }


}