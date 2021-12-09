package model;

import java.util.List;

public class StageInformationList {

    private static List<StageInformation> stages;

    private StageInformationList() {}

    static StageInformationList of() {
        List<StageInformation> lst = List.of(
                new StageInformation(1, 6, 6),
                new StageInformation(2, 5, 6),
                new StageInformation(3, 6, 6),
                new StageInformation(4, 6, 7)
        );
        stages = lst;
        return new StageInformationList();
    }

    List<StageInformation> getStageInformation(){
        return stages;
    }
}
