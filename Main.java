import java.util.List;

public class Main {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) throws Exception {
        Numbers numbers = new Numbers();
        GameMachine gameMachine = new GameMachine();
        GameManager manager = new GameManager();

        manager.sayHello();
        int stageNumber = 3;

        while (true) {
            Stage stage = gameMachine.getStage(stageNumber);
            outputView.initBoard(stage.board());

            while (true) {
                List<Command> commands = manager.getCommand(inputView.inputCommand());
                List<GameResult> result = gameMachine.play(stageNumber, commands);
                outputView.printResult(result);
//                return;
            }
        }


    }
}
