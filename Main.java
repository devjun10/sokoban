import model.GameMachine;
import model.GameManager;
import model.Stage;
import model.StageData;
import view.*;

import java.util.List;

public class Main {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        GameMachine gameMachine = new GameMachine();
        GameManager manager = new GameManager();

        manager.sayHello();

        int stageNumber = 1;
        int turn = 0;

        while (stageNumber < 5) {
            Stage stage = gameMachine.getStage(stageNumber);
            StageProgress currentStageProgress = StageProgress.NOT_CLEAR;
            outputView.printBoard(stage.getBoard());

            while (stage.isNotAnswer()) {
                List<Command> commands = manager.getCommand(inputView.inputCommand());
                List<GameResult> result = gameMachine.play(stageNumber, commands);

                for (GameResult gameResult : result) {
                    if (gameResult.getMessage().equals(Command.L.getCommand())) {
                        List<StageData> data = manager.getSlotData(gameMachine);
                        data.forEach(System.out::println);
                        manager.saySaveList();
                        String inputStage = inputView.inputStage();
                        int inputStageNumber = Integer.parseInt(inputStage.substring(0, 1));

                        if (!data.get(inputStageNumber - 1).getName().equals("Empty")) {
                            stage = gameMachine.loadSlotData(inputStageNumber);
                            stageNumber = stage.getStageNumber();
                            outputView.printBoard(stage.getBoard());
                            turn = 0;
                        } else {
                            manager.sayNoMap();
                            outputView.printBoard(stage.getBoard());
                        }
                        break;
                    }

                    if (gameResult.getMessage().equals(Command.R.getCommand())) {
                        stage.resetStage();
                        turn = 0;
                        manager.sayTurnReset();
                        outputView.printBoard(stage.getBoard());
                        break;
                    }

                    if (gameResult.getMessage().equals(Command.Q.getCommand())) {
                        manager.sayTurnCount(turn);
                        manager.sayTurnOff();
                        manager.turnOffTheGame();
                    }

                    if (gameResult.getMessage().equals(Command.C.getCommand())) {
                        manager.saySaveComplete();
                        stageNumber = stage.getStageNumber();
                        gameMachine.saveStage(stageNumber);
                        outputView.printBoard(stage.getBoard());
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
                        turn = manager.plusCount(turn);
                        manager.sayTurnCount(turn);
                        outputView.printGameResult(gameResult);
                    }
                }
            }
            
            turn = manager.turnInit();
            gameMachine.clearStage(stageNumber);
            stageNumber = manager.plusCount(stageNumber);
        }
        manager.sayGoodBye();
    }
}
