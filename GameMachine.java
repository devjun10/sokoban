public class GameMachine {

    private Board board = Board.of();

    private GameResult getCurrentBoard() {
        return new GameResult(board.getBoard());
    }

    public void move(Command command){

    }

    void updateBoard(String[][] updatedBoard){
        this.board.update(updatedBoard);
    }

}
