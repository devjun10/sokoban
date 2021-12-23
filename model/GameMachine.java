package model;

import view.GameResult;
import view.InputCommand;

import java.util.List;

public class GameMachine {

    private Disk disk = Disk.of();
    private Stages stages = Stages.of();

    public Stage getStage(int value) {
        return stages.getStage(value);
    }

    public List<GameResult> play(int stageNumber, List<InputCommand> commands) throws Exception {
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
        stage.resetMap();
    }

    public List<StageData> getSlotData() {
        return disk.getSlotData();
    }

}
