import java.util.List;
import java.util.stream.Stream;

public enum Direction {

    UP("U", "위쪽으로 한 칸 이동", List.of(1, 0)),
    DOWN("D", "아랫쪽으로 한 칸 이동", List.of(-1, 0)),
    RIGHT("R", "오른쪽으로 한 칸 이동", List.of(0, -1)),
    LEFT("L", "왼쪽으로 한 칸 이동", List.of(0, 1)),
    Q("Q", "프로그램 종료", List.of());

    private final String command;
    private final String description;
    private final List<Integer> nextPosition;

    Direction(String command, String description, List<Integer> nextPosition) {
        this.command = command;
        this.description = description;
        this.nextPosition = nextPosition;
    }

    public static Direction getDirection(String input) {
        return Stream.of(values())
                .filter(command -> command.command.toLowerCase().equals(input))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<Integer> getNextPosition() {
        return nextPosition;
    }

    @Override
    public String toString() {
        return this.toString();
    }
}
