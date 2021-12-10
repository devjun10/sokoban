package model;

import view.GameResult;
import view.InputCommand;
import view.commands.DirectionInputCommand;

import java.util.ArrayList;
import java.util.List;

import static utils.BoardUtils.convertIntArrayToStringArrayUsingSymbol;

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

    List<GameResult> execute(List<InputCommand> commands) {
        List<GameResult> results = new ArrayList<>();

        for (InputCommand inputCommand : commands) {
            Command command = SystemCommandFactory.getCommand(inputCommand);
            GameResult result = getResult(inputCommand);
            String message = command.execute(inputCommand);
            result.addMesage(message);
            results.add(result);
        }
        return results;
    }

    private GameResult getResult(InputCommand command) {
        if(command instanceof DirectionInputCommand){
            DirectionInputCommand directionInputCommand = (DirectionInputCommand) command;
            return this.board.push(directionInputCommand);
        }else {
            return new GameResult(convertIntArrayToStringArrayUsingSymbol(this.board.getIntBoard()));
        }
    }

    public GameResult resetStage() {
        this.board.reset();
        return new GameResult(this.board.getStringBoard());
    }

    public int getStageNumber() {
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