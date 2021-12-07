
public class GameMachine {

    private Disk disk = Disk.of();
    private Stages stages = Stages.of();
    private Board board = Board.of();


    GameResult getBoard() {
        return new GameResult(board.getBoard());
    }

    private void updateBoard(int[][] updatedBoard) {
        this.board.update(updatedBoard);
    }

}
