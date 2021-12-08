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

        String inputChoice = inputView.inputChoice();

        while (stageNumber < 5) {
            if (Choice.YES.cotent().equals(inputChoice)) {
                stageNumber = inputView.inputStageNumber();
                System.out.println("===============================");
                stage = gameMachine.loadSlotData(stageNumber);
                System.out.println(stage);
                System.out.println("===============================");
            }else {
                stage = gameMachine.getStage(stageNumber);
                stageNumber = stage.getStageNumber();
            }

            if (stageNumber > 1) {
                String saveChoice = inputView.inputChoice();
                if (Choice.YES.cotent().equals(saveChoice)) {
                    gameMachine.saveStage(stageNumber);
                }
            }
            StageProgress currentState = StageProgress.NOT_CLEAR;
            System.out.println("===========================");
            System.out.println("This");
            outputView.printInitStage(stage.getBoard());
            System.out.println("===========================");


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

                    if (gameResult.getMessage().equals(Command.SS.getCommand())) {
                        System.out.println("저장완료");
                        gameMachine.saveStage(stageNumber);
                        continue;
                    }

                    if (stage.checkAnswer(gameResult.getBoard())) {
                        if (currentState.equals(StageProgress.NOT_CLEAR)) {
                            manager.sayTurnClear(stageNumber);
                            manager.sayTurnCount(turn);
                        }
                        currentState = StageProgress.CLEAR;
                    }
                    if (currentState.equals(StageProgress.NOT_CLEAR)) {
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
