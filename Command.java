import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Command {

    UP("w", "W: 윗쪽으로 이동합니다.", List.of(-1, 0)),
    DOWN("s", "S: 아랫쪽으로 이동합니다.", List.of(1, 0)),
    RIGHT("d", "D: 오른쪽으로 이동합니다.", List.of(0, 1)),
    LEFT("a", "A: 왼쪽으로 이동합니다.", List.of(0, -1)),
    INVALID_COMMAND(String.valueOf(Long.MAX_VALUE), "(경고!) 해당 명령을 수행할 수 없습니다!", List.of()),
    R("r", "R: 스테이지를 초기화합니다.", List.of()),
    SS("ss", "S: 현재 진행상황을 저장합니다.", List.of()),
    L("l", "L: 세이브에서 진행상황을 불러옵니다", List.of()),
    Q("q", "Bye~", List.of());

    private final String command;
    private final String description;
    private final List<Integer> nextPosition;

    Command(String command, String description, List<Integer> nextPosition) {
        this.command = command;
        this.description = description;
        this.nextPosition = nextPosition;
    }

    public String getDescription() {
        return description;
    }

    public static Command getDirection(String input) {
        return Stream.of(values())
                .filter(position -> position.command.toLowerCase().equals(input))
                .findAny()
                .orElse(INVALID_COMMAND);
    }

    public static List<String> getCommands() {
        return Stream.of(values())
                .map(Command::getCommand)
                .map(String::toLowerCase)
                .sorted()
                .collect(Collectors.toUnmodifiableList());
    }

    public String getCommand() {
        return command;
    }

    public List<Integer> getNextPosition() {
        return nextPosition;
    }
}
