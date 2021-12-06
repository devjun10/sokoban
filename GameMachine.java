public class GameMachine {

    private Board board = Board.of();

    private GameResult getCurrentBoard() {
        return new GameResult(board.getBoard());
    }

    public void move(Command command) {
        Pair currentPlayerPosition = this.board.findPlayerPosition();
        int x = currentPlayerPosition.getX();
        int y = currentPlayerPosition.getY();

        int nextX = x + command.getNextPosition().get(0);
        int nextY = x + command.getNextPosition().get(1);

        String[][] newBoard = this.board.getBoard();
        newBoard[nextX][nextY] = "P";
        newBoard[x][y] = " ";

        this.board.update(newBoard);

    }

    void updateBoard(String[][] updatedBoard) {
        this.board.update(updatedBoard);
    }

}
