import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Pairs {

    private static List<Pair> pairs = new ArrayList<>();

    static {
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
                pairs.add(new Pair(row, col));
            }
        }
    }

    public static Pair of(int inputX, int inputY) {
        return pairs.stream()
                .filter(position -> position.getX() == inputX)
                .filter(position -> position.getY() == inputY)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
