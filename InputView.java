import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private Input input = new Input();

    private class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void inputMap() {
        String inputValue;
        while (true) {
            try {
                inputValue = input.br.readLine();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_INPUT_VALUE);
            } catch (Exception e) {
                System.out.println(ErrorMessage.INVALID_INPUT_VALUE);
            }
        }
    }

    private List<String> getWordsByLine(String value) {
        String[] wordArray = value.split("\n");
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

    private int getIntValue(String symbol) {
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
        return 0;
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

    private int[][] getStageSecondMap(List<String> lst) {
        int[][] intArray = new int[6][11];
        for (int i = 6; i < 13; i++) {
            String[] array = lst.get(i).split("");
            for (int j = 0; j < array.length; j++) {
                intArray[i - 6][j] = getIntValue(array[j]);
            }
        }
        return intArray;
    }

    public static void main(String[] args) throws Exception {
        String word = "Stage 1\n" +
                "#####\n" +
                "#OoP#\n" +
                "#####\n" +
                "=====\n" +
                "Stage 2\n" +
                "  #######\n" +
                "###  O  ###\n" +
                "#    o    #\n" +
                "# Oo P oO #\n" +
                "###  o  ###\n" +
                " #   O  # \n" +
                " ########";
        String[] words = word.split("\n");
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            lst.add(words[i]);
        }
    }

}
