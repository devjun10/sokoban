import java.util.HashMap;
import java.util.Map;

public class Stages {
    private final Map<Number, Stage> stages = new HashMap<>();

    Stages() {
        stages.put(Numbers.getValue(1), new FirstStage());
        stages.put(Numbers.getValue(2), new SecondStage());
        stages.put(Numbers.getValue(3), new ThirdStage());
    }
}
