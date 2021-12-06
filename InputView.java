import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private Input input = new Input();

    private List<String> commands;

    private InputView() {
        commands = Command.getCommands();
    };

    public static InputView of() {
        return new InputView();
    }

    private class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String inputCommand() {
        String value;
        System.out.print(Message.SOKOBAN);

        while (true) {
            try {
                value = input.br.readLine().toLowerCase();
                validateDirectionContains(value);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_INPUT_VALUE);
            } catch (Exception e) {
                System.out.println(ErrorMessage.INVALID_INPUT_VALUE);
            }
        }
        return value;
    }

    private void validateDirectionContains(String direction) {
        if (!commands.contains(direction)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_VALUE.toString());
        }
    }

    public List<StageResult> inputMap(String word) {
        return getResult(word);
    }

    private List<StageResult> getResult(String word) {
        List<String> words = getWordsSplitByLine(word);
        List<StageResult> results = new ArrayList<>();

        StageResult stageFirst = new StageResult(1, getStageFirstMap(words));
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

    private int[][] getStageFirstMap(List<String> lst) {
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
            int count = array.length;
            for (int j = 0; j < count; j++) {
                intArray[i - 6][j] = getIntValue(array[j]);
            }
        }
        return intArray;
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
        if (symbol.equals(" ")) {
            return 5;
        }
        return 5;
    }
}