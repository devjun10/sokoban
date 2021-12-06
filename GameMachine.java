public class GameMachine {

    private Board board = Board.of();

    private GameResult getCurrentBoard() {
        return new GameResult(board.getBoard());
    }

    public GameResult move(Command command) {
        Pair currentPlayerPosition = this.board.findPlayerPosition();
        int x = currentPlayerPosition.getX();
        int y = currentPlayerPosition.getY();

        int nextX = x + command.getNextPosition().get(0);
        int nextY = x + command.getNextPosition().get(1);

        String[][] newBoard = this.board.getBoard();
        if (this.board.validatePosition(nextX, nextY)) {
            newBoard[nextX][nextY] = "P";
            newBoard[x][y] = " ";
            updateBoard(newBoard);
            return new GameResult(this.board.getBoard());
        }
        return new GameResult(this.board.getBoard());
    }

    private void updateBoard(String[][] updatedBoard) {
        this.board.update(updatedBoard);
    }

}
