import java.util.List;

public class Main {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) throws Exception {

        GameMachine gameMachine = new GameMachine();
        outputView.initBoard(gameMachine.getBoard().getBoard());
        GameManager manager = new GameManager();

        while (true) {
            List<String> inputValues = inputView.inputCommand();
            List<Command> commands = manager.getCommand(inputValues);
            GameResult result = gameMachine.move(commands);
        }
    }
}
