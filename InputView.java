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

    private void parseString(String value) {
        String stageOne;
        int[][] stageOneMap = new int[5][5];
    }

    private List<String> getWordsByLine(String value) {
        String[] wordArray = value.split("\n");
        List<String> words = new ArrayList<>();
        for (int i = 0; i < wordArray.length; i++) {
            words.add(wordArray[i]);
        }
        return words;
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
