import java.util.List;

public class GameMachine {

    private Board board = Board.of();

    GameResult getBoard() {
        return new GameResult(board.getBoard());
    }


    public GameResult move(List<Command> commands) {
        for (Command command : commands) {
            Pair currentPlayerPosition = this.board.findPlayerPosition();
            int x = currentPlayerPosition.getX();
            int y = currentPlayerPosition.getY();
            int nextX = x + command.getNextPosition().get(0);
            int nextY = y + command.getNextPosition().get(1);
            String[][] newBoard = this.board.getBoard();
            if (this.board.validatePosition(Pairs.of(nextX, nextY))) {
                newBoard[x][y] = " ";
                newBoard[nextX][nextY] = "P";
                updateBoard(newBoard);
            } else {
                System.out.println(ErrorMessage.IMPOSSIBLE_COMMAND);
                this.board.update(newBoard);
            }
        }
        return new GameResult(this.board.getBoard());
    }


    private void updateBoard(String[][] updatedBoard) {
        this.board.update(updatedBoard);
    }

}
