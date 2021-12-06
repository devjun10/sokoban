import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private Input input = new Input();

    private class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }

    public List<StageResult> inputMap(String word) throws IOException {
        return getResult(word);
    }

    private List<StageResult> getResult(String word) {
        List<String> words = getWordsSplitByLine(word);
        List<StageResult> results = new ArrayList<>();

        StageResult stageFirst = new StageResult(1, getStageOneMap(words));
        StageResult stageSecond = new StageResult(2, getStageSecondMap(words));

        results.add(stageFirst);
        results.add(stageSecond);
        return results;
    }

    private List<String> getWordsSplitByLine(String word) {
        String[] wordArray = word.split("\n");
        List<String> words = new ArrayList<>();
        words.addAll(Arrays.asList(wordArray));
        return words;
    }

    private int[][] getStageOneMap(List<String> lst) {
        String[][] stringArray = new String[3][5];
        for (int i = 0; i < 3; i++) {
            stringArray[i] = lst.get(i + 1).split("").clone();
        }
        return getIntArray(stringArray);
    }

    private int[][] getStageSecondMap(List<String> lst) {
        int[][] intArray = new int[7][11];
        for (int i = 6; i < 13; i++) {
            String[] array = lst.get(i).split("");
            for (int j = 0; j < array.length; j++) {
                intArray[i - 6][j] = getIntValue(array[j]);
            }
        }
        return intArray;
    }

    private static int getIntValue(String symbol) {

        if (symbol.equals("#")) {
            return 0;
        }
        if (symbol.equals("O")) {
            return 1;
        }
        if (symbol.equals("o")) {
            return 2;
        }
        if (symbol.equals("P")) {
            return 3;
        }
        if (symbol.equals("=")) {
            return 4;
        }
        return 5;
    }

    private int[][] getIntArray(String[][] stringArray) {
        int[][] intArray = new int[stringArray.length][stringArray[0].length];
        for (int row = 0; row < stringArray.length; row++) {
            for (int col = 0; col < stringArray[0].length; col++) {
                intArray[row][col] = getIntValue(stringArray[row][col]);
            }
        }
        return intArray;
    }

    public static void main(String[] args) throws Exception {
        String word = "Stage 1\n" + "#####\n" + "#OoP#\n" + "#####\n" + "=====\n" + "Stage 2\n" + "  #######\n" + "###  O  ###\n" + "#    o    #\n" + "# Oo P oO #\n" + "###  o  ###\n" + " #   O  # \n" + " ########";
        String[] words = word.split("\n");
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            lst.add(words[i]);
        }

        InputView view = new InputView();
        List<StageResult> results = view.getResult(word);
        OutputView outputView = new OutputView();
        outputView.print(results);

//        for (int row = 0; row < 7; row++) {
//            System.out.println();
//            for (int col = 0; col < 11; col++) {
//                System.out.print(results.get(1).getMap()[row][col]);
//            }
//        }
//        System.out.println();
//        System.out.println();
//        System.out.println("가로 크기= " + results.get(0).getHorizontalCount());
//        System.out.println("세로 크기= " + results.get(0).getVerticalCount());
//        System.out.println("구멍 갯수= " + results.get(0).getHoleCount());
//        System.out.println("공의 수= " + results.get(0).getBallCount());
//        System.out.println("플레이어 위치=  " + results.get(0).getPlayerPosition());
//        System.out.println("====================");
//        System.out.println("가로 크기= " + results.get(1).getHorizontalCount());
//        System.out.println("세로 크기= " + results.get(1).getVerticalCount());
//        System.out.println("구멍 갯수= " + results.get(1).getHoleCount());
//        System.out.println("공의 수= " + results.get(1).getBallCount());
//        System.out.println("플레이어 위치=  " + results.get(1).getPlayerPosition());
//
//
    }
}