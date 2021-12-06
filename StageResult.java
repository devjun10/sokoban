public class StageResult {

    private int stageCount;
    private int ho;
    private int vertical;
    private int holeCount;
    private int ballCount;
    private Position playerPosition;

    public StageResult(int stageCount, int ho, int vertical, int holeCount, int ballCount, Position playerPosition) {
        this.stageCount = stageCount;
        this.ho = ho;
        this.vertical = vertical;
        this.holeCount = holeCount;
        this.ballCount = ballCount;
        this.playerPosition = playerPosition;
    }

    public int getStageCount() {
        return stageCount;
    }

    public int getHo() {
        return ho;
    }

    public int getVertical() {
        return vertical;
    }

    public int getHoleCount() {
        return holeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public Position getPlayerPosition() {
        return playerPosition;
    }
}
