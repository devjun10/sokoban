import java.util.ArrayList;
import java.util.List;

public class Stage {

    private Board board;
    private StageInformation stageInformation;

    Stage() {};

    Stage(Board board, StageInformation stageInformation) {
        this.board = board;
        this.stageInformation = stageInformation;
    }

    public String[][] getBoard() {
        return board.getBoard();
    }

    public List<GameResult> execute(List<Command> commandList) {
        List<GameResult> results = new ArrayList<>();
        for (Command command : commandList) {
            if(command.equals(Command.R)){
                return List.of(resetStage());
            }
            results.add(this.board.push(command));
        }
        return results;
    }

    public GameResult resetStage(){
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
}