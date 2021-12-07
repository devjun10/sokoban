public class Stage {


    private Board board = Board.of();
    private StageInformation stageInformation;

    Stage() {};

    public Stage(Board board, StageInformation stageInformation) {
        this.board = board;
        this.stageInformation = stageInformation;
    }

    public String[][] board() {
        return board.getBoard();
    }

    @Override
    public String toString() {
        return "Stage{" +
                "id=" + stageInformation.getId() + ", stageInformation=" + stageInformation +
                '}';
    }
}