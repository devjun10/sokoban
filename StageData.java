public enum StageData {

    STAGE_ONE(1, "Stage1"),
    STAGE_TWO(2, "Stage2"),
    STAGE_THREE(3, "Stage3"),
    STAGE_FOUR(4, "Stage4"),
    STAGE_FIVE(5, "Stage5"),
    EMPTY(0, "Empty");

    private final int stage;
    private final String description;


    StageData(int stage, String description) {
        this.stage = stage;
        this.description = description;
    }

    public int getStage() {
        return stage;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
