package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Position {

    private static List<Point> points = new ArrayList<>();

    static {
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
                points.add(new Point(row, col));
            }
        }
    }

    public static Point of(int inputX, int inputY) {
        return points.stream()
                .filter(position -> position.getX() == inputX)
                .filter(position -> position.getY() == inputY)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
