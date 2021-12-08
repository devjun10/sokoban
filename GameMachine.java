import java.util.List;

public class GameMachine {

    private Disk disk = Disk.of();
    private Stages stages = Stages.of();
    private Board board = Board.of();


    GameResult getBoard() {
        return new GameResult(board.getBoard());
    }

    Stage getStage(int value) {
        return stages.getStage(value);
    }

    public List<GameResult> play(int stageNumber, List<Command> commands) {
        Stage stage = stages.getStage(stageNumber);
        return stage.execute(commands);
    }

    public void saveStage(int stageNumber) {
        Stage stage = stages.getStage(stageNumber);
        disk.save(stageNumber, stage.getBoard());
    }

    public Stage loadSlotData(int stageNumber) {
        Stage stage = stages.getStage(stageNumber);
        int[][] savedData = disk.loadSlotData(stageNumber);
        stage.loadStageData(savedData);
        return stage;
    }

    public void clearStage(int stageNumber) {
        Stage stage = stages.getStage(stageNumber);
        stage.resetStage();
    }
}
