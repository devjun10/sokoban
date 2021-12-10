import model.*;
import view.GameResult;
import view.InputCommand;
import view.InputView;
import view.OutputView;
import view.commands.StageProgress;
import view.commands.SystemInputCommand;

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

        while (stageNumber < 10) {
            Stage stage = gameMachine.getStage(stageNumber);
            StageProgress currentStageProgress = StageProgress.NOT_CLEAR;
            outputView.printBoard(stage.getBoard());

            while (stage.isNotAnswer()) {
                List<InputCommand> inputCommands = manager.getCommand(inputView.inputCommand());
                List<GameResult> result = gameMachine.play(stageNumber, inputCommands);

                for (GameResult gameResult : result) {
                    if (gameResult.getMessage().equals(SystemInputCommand.L.getCommand())) {
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

                    if (gameResult.getMessage().equals(SystemInputCommand.R.getCommand())) {
                        stage.resetStage();
                        turn = 0;
                        manager.sayTurnReset();
                        outputView.printBoard(stage.getBoard());
                        break;
                    }

                    if (gameResult.getMessage().equals(SystemInputCommand.Q.getCommand())) {
                        manager.sayTurnCount(turn);
                        manager.sayTurnOff();
                        manager.turnOffTheGame();
                    }

                    if (gameResult.getMessage().equals(SystemInputCommand.C.getCommand())) {
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
