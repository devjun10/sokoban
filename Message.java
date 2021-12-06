public enum Message {

    STAGE_INFO("Stage: "),
    HORIZONTAL_LENGTH("가로크기: "),
    VERTICAL_LENGTH("세로크기: "),
    HOLE_COUNT("구멍 수: "),
    BALL_COUNT("공의 수: "),
    PLAYER_POSITION("플레이어 위치: "),
    SOKOBAN("SOKOBAN> ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
