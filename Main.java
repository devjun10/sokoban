import model.*;
import view.GameResult;
import view.InputCommand;
import view.InputView;
import view.OutputView;
import view.commands.StageProgress;
import view.commands.SystemInputCommand;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        GameManager manager = new GameManager();
        while (manager.getStageNumber() < 5) {
            Stage stage = gameMachine.getStage(stageNumber);
            StageProgress currentStageProgress = StageProgress.NOT_CLEAR;
            outputView.printBoard(stage.getBoard());
            manager.proceedGame();
            turn = turnInit();
            gameMachine.clearStage(stageNumber);
            stageNumber = plusCount(stageNumber);
        }
        manager.sayGoodBye();
    }
}
