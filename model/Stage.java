package model;

import view.GameResult;
import view.InputCommand;
import view.commands.DirectionCommand;

import java.util.ArrayList;
import java.util.List;

import static model.SystemCommandExecutionResultFactory.getCommand;
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

    List<GameResult> execute(List<InputCommand> commands) throws Exception {
        List<GameResult> commandExecutableResults = new ArrayList<>();

        for (InputCommand inputCommand : commands) {
            GameResult eachResult = getBoard(inputCommand);
            Command command = getCommand(inputCommand);

            String message = command.execute(inputCommand);
            addMessage(eachResult, message);

            commandExecutableResults.add(eachResult);
        }
        return commandExecutableResults;
    }

    void addMessage(GameResult result, String message) {
        result.addMesage(message);
    }

    private GameResult getBoard(InputCommand command) {
        if (command instanceof DirectionCommand) {
            DirectionCommand directionCommand = (DirectionCommand) command;
            return this.board.push(directionCommand);
        }
        return new GameResult(convertIntArrayToStringArrayUsingSymbol(this.board.getIntBoard()));
    }

    public GameResult resetMap() {
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