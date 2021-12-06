public class GameMachine {

    private Board board = Board.of();

    private GameResult getCurrentBoard() {
        return new GameResult(board.getBoard());
    }

}
