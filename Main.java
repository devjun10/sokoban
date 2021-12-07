import java.util.List;

public class Main {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) throws Exception {
        GameMachine gameMachine = new GameMachine();
        GameManager manager = new GameManager();

        manager.sayHello();
        int stageNumber = 1;
        int turn = 0;

        while (stageNumber < 5) {
            Stage stage = gameMachine.getStage(stageNumber);
            outputView.initBoard(stage.getBoard());

            while (stage.isNotAnswer()) {
                List<Command> commands = manager.getCommand(inputView.inputCommand());
                if (commands.get(0).equals(Command.R)) {
                    stage.resetStage();
                    turn = 0;
                    manager.sayTurnReset();
                }
                List<GameResult> result = gameMachine.play(stageNumber, commands);
                outputView.printResult(result);
                turn = manager.plusTurn(turn);
                manager.sayTurnCount(turn);
            }
            turn = manager.turnInit();
            if (turn == 0) {
                manager.sayTurnClear(stageNumber);
            }
            stageNumber = manager.stageUp(stageNumber);
        }
        manager.sayGoodBye();
    }
}
