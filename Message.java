public enum Message {

    STAGE_INFO("Stage "),
    CLEAR("클리어!"),
    CLEAR_CELEBRATION("전체 게임을 클리어하셨습니다!"),
    TURN_COUNT("턴수:"),
    CELEBRATION("축하드립니다!"),
    DOT("..."),

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
