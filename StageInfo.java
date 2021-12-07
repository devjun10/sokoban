import java.util.List;
import java.util.NoSuchElementException;

public class StageInfo {

    private static List<Information> stages;

    private StageInfo() {
        List<Information> lst = List.of(new Information(1, 2, 3));
        stages = lst;
    }

    static StageInfo of() {
        return new StageInfo();
    }

    static Information getInformation(int inputValue) {
        return stages.stream()
                .filter(number->number.getMaxValue()==1)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

}
