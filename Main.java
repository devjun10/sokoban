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

        String choice = inputView.inputChoice();
        if (Choice.YES.getDescription().equals(choice)) {
//            stageNumber = inputView.inputChoice();
        }
        while (stageNumber < 5) {
            Stage stage = gameMachine.getStage(stageNumber);
            outputView.initBoard(stage.getBoard());
            boolean turnCount = false;

            while (stage.isNotAnswer()) {
                List<Command> commands = manager.getCommand(inputView.inputCommand());

                List<GameResult> result = gameMachine.play(stageNumber, commands);
                for (GameResult gameResult : result) {
                    if (gameResult.getMessage().equals(Command.R.getCommand())) {
                        stage.resetStage();
                        turn = 0;
                        manager.sayTurnReset();
                        outputView.initBoard(stage.getBoard());
                        break;
                    }
                    if (gameResult.getMessage().equals(Command.Q.getCommand())) {
                        manager.sayTurnCount(turn);
                        manager.sayTurnOff();
                        manager.turnOffTheGame();
                    }
//                    if (!turnCount)
//                        turn = manager.plusTurn(turn);
                    if (stage.checkAnswer(gameResult.getBoard())) {
                        if (!turnCount) {
                            manager.sayTurnClear(stageNumber);
                            manager.sayTurnCount(turn);
                        }
                        turnCount = true;
                    }
                    if (!turnCount) {
                        turn = manager.plusTurn(turn);
                        manager.sayTurnCount(turn);
                        outputView.printBoard(gameResult);
                    }
                }
            }
            turn = manager.turnInit();
            stageNumber = manager.stageUp(stageNumber);
        }
        manager.sayGoodBye();
    }
}
