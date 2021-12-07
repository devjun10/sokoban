public enum Message {

    STAGE_INFO("Stage "),
    BLANK("\n"),
    CLEAR("클리어!"),
    CLEAR_CELEBRATION("전체 게임을 클리어하셨습니다!"),
    TURN_COUNT("턴수:"),
    CELEBRATION("축하드립니다!"),
    DOT("..."),
    GREET("소코반의 세계에 오신 것을 환영합니다!\n^오^\n"),
    TURN_RESET("해당 턴을 초기화 합니다.\n"),
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
