package model;

import view.InputCommand;
import view.GameResult;
import view.commands.MoveInputCommand;

import java.util.ArrayList;
import java.util.List;

public class Stage {

    private Board board;
    private StageInformation stageInformation;
    private SaveData saveData = SaveData.of();

    Stage(Board board, StageInformation stageInformation) {
        this.board = board;
        this.stageInformation = stageInformation;
        saveData.init(board.getIntBoard());
    }

    public String[][] getBoard() {
        return board.getStringBoard();
    }

    List<GameResult> execute(List<InputCommand> directionInputCommandList) {
        List<GameResult> results = new ArrayList<>();
        for (InputCommand directionInputCommand : directionInputCommandList) {
            if(directionInputCommand.equals(MoveInputCommand.L)){
                results.add(new GameResult(MoveInputCommand.L.getCommand()));
                return results;
            }
            if (directionInputCommand.equals(MoveInputCommand.Q)) {
                results.add(new GameResult(MoveInputCommand.Q.getCommand()));
                return results;
            }
            if (directionInputCommand.equals(MoveInputCommand.R)) {
                results.add(new GameResult(MoveInputCommand.R.getCommand()));
                continue;
            }
            if (directionInputCommand.equals(MoveInputCommand.C)) {
                results.add(new GameResult(MoveInputCommand.C.getCommand()));
                continue;
            }
            GameResult result = getResult((MoveInputCommand) directionInputCommand);
            results.add(result);
        }
        return results;
    }

    private GameResult getResult(MoveInputCommand directionCommand){
        GameResult result = this.board.push(directionCommand);
        if(result.getMessage()==null)
            result.addMesage(directionCommand.getCommand());
        return result;
    }

    public GameResult resetStage() {
        this.board.reset();
        return new GameResult(this.board.getStringBoard());
    }

    public int getStageNumber(){
        return stageInformation.getId();
    }

    public boolean isNotAnswer() {
        return !this.board.isAnswer();
    }

    public boolean checkAnswer(String[][] board) {
        return this.board.checkAnswer(board);
    }

    void loadStageData(int[][] savedData) {
        this.board.update(savedData);
    }

    @Override
    public String toString() {
        return "Stage{" +
                "id=" + stageInformation.getId() + ", stageInformation=" + stageInformation +
                '}';
    }
}