
public class GameMachine {

    private Stages stages;
    private Board board = Board.of();

    GameResult getBoard() {
        return new GameResult(board.getBoard());
    }
//
//
//    public GameResult move(List<Command> commands) {
//        for (Command command : commands) {
//            if (command.equals(Command.INVALID_COMMAND)) {
//                System.out.println();
//                System.out.println(command.getDescription());
//                printCurrent(this.board.getBoard());
//                continue;
//            }
//            Pair currentPlayerPosition = this.board.findPlayerPosition();
//
//            int x = currentPlayerPosition.getX();
//            int y = currentPlayerPosition.getY();
//            int nextX = x + command.getNextPosition().get(0);
//            int nextY = y + command.getNextPosition().get(1);
//
//            String[][] newBoard = this.board.getBoard();
//
//            if (this.board.validatePosition(Pairs.of(nextX, nextY))) {
//                System.out.println();
//                System.out.println(command.getDescription());
//                newBoard[x][y] = " ";
//                newBoard[nextX][nextY] = "P";
//                updateBoard(newBoard);
//                printCurrent(newBoard);
//            } else {
//                System.out.println();
//                System.out.println(command.getDescription());
//                printCurrent(newBoard);
//                this.board.update(newBoard);
//            }
//        }
//        return new GameResult(this.board.getBoard());
//    }
//
//    private void printCurrent(String[][] board) {
//        for (int row = 0; row < 7; row++) {
//                System.out.println();
//            for (int col = 0; col < 11; col++) {
//                System.out.print(board[row][col]);
//            }
//        }
//        System.out.println();
//    }
//
//
//    private void updateBoard(String[][] updatedBoard) {
//        this.board.update(updatedBoard);
//    }

}
