import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) throws Exception {
        String word = "Stage 1\n" + "#####\n" + "#OoP#\n" + "#####\n" + "=====\n" + "Stage 2\n" + "  #######  \n" + "###  O  ###\n" + "#    o    #\n" + "# Oo P oO #\n" + "###  o  ###\n" + " #   O  #  \n" + " ########  ";
        String[] words = word.split("\n");
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            lst.add(words[i]);
        }
        InputView view = new InputView();
        List<StageResult> results = view.inputMap(word);
        OutputView outputView = new OutputView();
        outputView.print(results);

        Command command = Command.getDirection("q");
        if(command.equals(Command.Q)){
            System.out.println("게임 종료");
            return;
        }
    }
}
