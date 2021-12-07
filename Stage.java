import java.util.ArrayList;
import java.util.List;

public class Stage {

    private Board board;
    private StageInformation stageInformation;
    private SaveData saveData = SaveData.of();

    Stage() {};

    Stage(Board board, StageInformation stageInformation) {
        this.board = board;
        this.stageInformation = stageInformation;
        saveData.init(board.copyBoard());
    }

    public String[][] getBoard() {
        return board.getBoard();
    }

    public List<GameResult> execute(List<Command> commandList) {
        List<GameResult> results = new ArrayList<>();
        List<GameResult> executeResult = new ArrayList<>();
        for (Command command : commandList) {
            if (command.equals(Command.Q)) {
                // 이 직전 까지를 모두 더해야함
                results.add(new GameResult());
                return results;
            }
            if (command.equals(Command.R)) {
                results.add(new GameResult(Command.R.getCommand()));
                saveData.resetData();
                continue;
            }
            GameResult result = this.board.push(command);
            results.add(result);
            executeResult.add(result);
        }
        saveData.addAll(executeResult);
        return results;
    }

    public GameResult resetStage() {
        this.board.reset();
        return new GameResult(this.board.getBoard());
    }

    @Override
    public String toString() {
        return "Stage{" +
                "id=" + stageInformation.getId() + ", stageInformation=" + stageInformation +
                '}';
    }

    public boolean isNotAnswer() {
        return !this.board.isAnswer();
    }


    public boolean checkAnswer(String[][] board) {
        return this.board.checkAnswer(board);
    }
}