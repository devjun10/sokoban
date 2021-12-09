package model;

import view.Command;
import view.GameResult;

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

    List<GameResult> execute(List<Command> commandList) {
        List<GameResult> results = new ArrayList<>();
        for (Command command : commandList) {
            if(command.equals(Command.L)){
                results.add(new GameResult(Command.L.getCommand()));
                return results;
            }
            if (command.equals(Command.Q)) {
                results.add(new GameResult(Command.Q.getCommand()));
                return results;
            }
            if (command.equals(Command.R)) {
                results.add(new GameResult(Command.R.getCommand()));
                continue;
            }
            if (command.equals(Command.C)) {
                results.add(new GameResult(Command.C.getCommand()));
                continue;
            }
            GameResult result = getResult(command);
            results.add(result);
        }
        return results;
    }

    private GameResult getResult(Command command){
        GameResult result = this.board.push(command);
        if(result.getMessage()==null)
            result.addMesage(command.getCommand());
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