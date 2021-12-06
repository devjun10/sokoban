public enum ErrorMessage {

    INVALID_INPUT_VALUE("올바르지 않은 입력 입니다.");

    private final String description;

    ErrorMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
