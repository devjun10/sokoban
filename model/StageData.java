package model;

import java.util.Objects;

public class StageData {

    private int stageId;
    private String name;

    public StageData(int stageId, String name) {
        this.stageId = stageId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void editName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StageData stageData = (StageData) o;
        return stageId == stageData.stageId && Objects.equals(name, stageData.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stageId, name);
    }

    @Override
    public String toString() {
        return stageId+": " + name;
    }
}
