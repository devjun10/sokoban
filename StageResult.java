public class StageResult {

    private int stage;
    private int horizontalCount;
    private int verticalCount;
    private int holeCount;
    private int ballCount;
    private int[][] map;
    private Position playerPosition;

    public StageResult(int stage, int[][] map) {
        this.stage = stage;
        this.map = map;
        this.horizontalCount = map[0].length;
        this.verticalCount = map.length;
        this.holeCount = getHoleCount(map);
        this.ballCount = getBallCount(map);
        this.playerPosition = getPlayerPosition(map);
    }

    public int[][] getMap() {
        return map;
    }

    private int getHoleCount(int[][] map) {
        int count = 0;
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if (map[row][col] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private int getBallCount(int[][] map) {
        int count = 0;
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if (map[row][col] == 2) {
                    count++;
                }
            }
        }
        return count;
    }

    private Position getPlayerPosition(int[][] map) {
        int count = 0;
        int playerX = Integer.MAX_VALUE;
        int playerY = Integer.MAX_VALUE;
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if (map[row][col] == 3) {
                    playerX = row;
                    playerY = col;
                }
            }
        }
        return new Position(playerX, playerY);
    }

    public int getStage() {
        return stage;
    }

    public int getHorizontalCount() {
        return horizontalCount;
    }

    public int getVerticalCount() {
        return verticalCount;
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
