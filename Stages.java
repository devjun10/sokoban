import java.util.HashMap;
import java.util.Map;

public class Stages {

    private static final Map<Integer, Stage> stages = new HashMap<>();

    private Stages() {}

    public static void putStage(int id, StageInformation information, Board board) {
        stages.put(id, new Stage(board, information));
    }

    public static Stages of() {
        return new Stages();
    }

    public Stage getStage(int value){
        return stages.get(value);
    }
}
