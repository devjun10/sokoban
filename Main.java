import model.*;

public class Main {
    public static void main(String[] args) throws Exception {
        GameManager manager = new GameManager();
        while (manager.getCurrentStageNumber() < 5) {
//            Stage stage = gameMachine.getStage(stageNumber);
//            StageProgress currentStageProgress = StageProgress.NOT_CLEAR;
//            outputView.printBoard(stage.getBoard());
            manager.proceedGame();
//            turn = turnInit();
//            gameMachine.clearStage(stageNumber);
//            stageNumber = plusCount(stageNumber);
        }
        manager.sayGoodBye();
    }
}
