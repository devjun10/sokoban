public class StageData {

    private int stageId;
    private String name;

    public StageData(int stageId, String name) {
        this.stageId = stageId;
        this.name = name;
    }

    public int getStageId() {
        return stageId;
    }

    public String getName() {
        return name;
    }

    public void editName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return stageId+": " + name;
    }
}
