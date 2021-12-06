public class StageResult {

    private int stageCount;
    private int ho;
    private int vertical;
    private int holeCount;
    private int ballCount;
    private int[][] map;
    private Position playerPosition;

    public StageResult(int[][] map) {
        this.map = map;
    }

    public int[][] getMap() {
        return map;
    }
}
