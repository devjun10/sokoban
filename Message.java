public enum Message {

    ASK_LOAD_STAGE_DATA("저장된 스테이지의 데이터를 불러오시겠습니까? (y/n) \n"),
    ASK_STAGE_NUMBER("몇 번째 스테이지의 데이터를 불러오시겠습니까? "),
    BYE("Bye~ "),
    STAGE_INFO("Stage "),
    BLANK("\n"),
    LINE("========================================================="),
    CELEBRATION("축하드립니다!"),
    CLEAR("클리어!"),
    CLEAR_CELEBRATION("전체 게임을 클리어하셨습니다!"),
    TURN_COUNT("턴수:"),
    DOT("..."),
    GREET("소코반의 세계에 오신 것을 환영합니다!\n^오^\n"),
    SAVE("저장 완료"),
    TURN_RESET("해당 턴을 초기화 합니다. 초기화 이후에는 게임의 안전성을 위해 추가 명령은 실행되지 않습니다.\n"),
    SAVE_DATA("현재 스테이지를 슬롯에 저장하시겠습니까?"),
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
