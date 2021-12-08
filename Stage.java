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
        for (Command command : commandList) {
            if (command.equals(Command.Q)) {
                // 이 직전 까지를 모두 더해야함
                results.add(new GameResult(Command.Q.getCommand()));
                return results;
            }
            if (command.equals(Command.R)) {
                results.add(new GameResult(Command.R.getCommand()));
                continue;
            }

            if (command.equals(Command.SS)) {
                results.add(new GameResult(Command.SS.getCommand()));
                continue;
            }
            GameResult result = this.board.push(command);
            if(result.getMessage()==null)
                result.addMesage(command.getCommand());
            results.add(result);
        }
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