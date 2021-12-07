import java.util.List;

public class GameMachine {

    private Disk disk = Disk.of();
    private Stages stages = Stages.of();
    private Board board = Board.of();


    GameResult getBoard() {
        return new GameResult(board.getBoard());
    }

    Stage getStage(int value){
        return stages.getStage(value);
    }

    private void updateBoard(int[][] updatedBoard) {
        this.board.update(updatedBoard);
    }

    public List<GameResult> play(int stageNumber, List<Command> commands) {
        Stage stage = stages.getStage(stageNumber);
        return stage.execute(commands);
    }
}
