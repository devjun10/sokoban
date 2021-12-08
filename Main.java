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

        Stage stage;

        while (stageNumber < 5) {
            manager.askLoadSavedData();
            String inputChoice = inputView.inputChoice();
            if (Choice.YES.cotent().equals(inputChoice)) {
                manager.askStageNumber();
                stageNumber = inputView.inputIntValue();
                stage = gameMachine.loadSlotData(stageNumber);
            } else {
                stage = gameMachine.getStage(stageNumber);
                stageNumber = stage.getStageNumber();
            }

            StageProgress currentStageProgress = StageProgress.NOT_CLEAR;
            outputView.printInitStage(stage.getBoard());

            while (stage.isNotAnswer()) {
                List<Command> commands = manager.getCommand(inputView.inputCommand());

                List<GameResult> result = gameMachine.play(stageNumber, commands);
                for (GameResult gameResult : result) {
                    if (gameResult.getMessage().equals(Command.R.getCommand())) {
                        stage.resetStage();
                        turn = 0;
                        manager.sayTurnReset();
                        outputView.printInitStage(stage.getBoard());
                        break;
                    }

                    if (gameResult.getMessage().equals(Command.Q.getCommand())) {
                        manager.sayTurnCount(turn);
                        manager.sayTurnOff();
                        manager.turnOffTheGame();
                    }

                    if (gameResult.getMessage().equals(Command.C.getCommand())) {
                        manager.saySaveComplete();
                        gameMachine.saveStage(stageNumber);
                        outputView.printInitStage(stage.getBoard());
                        continue;
                    }

                    if (stage.checkAnswer(gameResult.getBoard())) {
                        if (currentStageProgress.equals(StageProgress.NOT_CLEAR)) {
                            manager.sayTurnClear(stageNumber);
                            manager.sayTurnCount(turn);
                        }
                        currentStageProgress = StageProgress.CLEAR;
                    }
                    if (currentStageProgress.equals(StageProgress.NOT_CLEAR)) {
                        turn = manager.plusTurn(turn);
                        manager.sayTurnCount(turn);
                        outputView.printBoard(gameResult);
                    }
                }
            }
            turn = manager.turnInit();
            gameMachine.clearStage(stageNumber);
            stageNumber = manager.stageUp(stageNumber);
        }
        manager.sayGoodBye();
    }
}
