import java.util.ArrayList;
import java.util.List;

public class Stage {

    private Board board;
    private StageInformation stageInformation;

    Stage() {
    }

    ;

    Stage(Board board, StageInformation stageInformation) {
        this.board = board;
        this.stageInformation = stageInformation;
    }

    public String[][] board() {
        return board.getBoard();
    }

    public List<GameResult> execute(List<Command> commandList) {
        List<GameResult> results = new ArrayList<>();
        for (Command command : commandList) {
            results.add(this.board.push(command));
        }
        return results;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "id=" + stageInformation.getId() + ", stageInformation=" + stageInformation +
                '}';
    }
}