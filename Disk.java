import java.util.List;

public class Disk {

    private Init init = Init.of();
    private Slot slot = Slot.of();

    private Disk() {};

    public static Disk of() {
        return new Disk();
    }

    public void save(int stageNumber, String[][] array) {
        slot.saveData(stageNumber, array);
    }

    public int[][] loadSlotData(int stageNumber) {
        return slot.loadSaveData(stageNumber);
    }

    public List<StageData> getSlotData() {
        return slot.getSlotData();
    }
}
