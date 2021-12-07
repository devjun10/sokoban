
public class GameMachine {

    private Stages stages;
    private Board board = Board.of();

    GameResult getBoard() {
        return new GameResult(board.getBoard());
    }

    private void updateBoard(int[][] updatedBoard) {
        this.board.update(updatedBoard);
    }

}
