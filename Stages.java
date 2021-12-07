import java.util.HashMap;
import java.util.Map;

public class Stages {

    private static final Map<Integer, Stage> stages = new HashMap<>();

    Stages() {
    }

    public static void putStage(int id, StageInformation information, Board board) {
        stages.put(id, new Stage(id, board, information));
    }

    public static Stages of() {
        return new Stages();
    }
}
