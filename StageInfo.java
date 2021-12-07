import java.util.List;
import java.util.NoSuchElementException;

public class StageInfo {

    private static List<StageInformation> stages;

    private StageInfo() {
    }

    static StageInfo of() {
        List<StageInformation> lst = List.of(
                new StageInformation(1, 6, 6),
                new StageInformation(2, 6, 5),
                new StageInformation(3, 6, 6)
        );
        stages = lst;
        return new StageInfo();
    }

    StageInformation getInformation(int inputId) {
        return stages.stream()
                .filter(stageInformation -> stageInformation.getId() == inputId)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public static List<StageInformation> getStages() {
        return stages;
    }
}
