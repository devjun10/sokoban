import java.util.ArrayList;
import java.util.List;

public class Pairs {

    private static List<Pair> pairs = new ArrayList<>();

    static {
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
                pairs.add(new Pair(row, col));
            }
        }
    }
}
