public class Stage {

    private int id;
    private Board board = Board.of();
    private StageInformation stageInformation;


    public Stage(int id, Board board, StageInformation stageInformation) {
        this.id = id;
        this.board = board;
        this.stageInformation = stageInformation;
    }
}