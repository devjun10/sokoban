package view.commands;

import utils.Point;
import view.InputCommand;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.Position.movePoint;

public enum DirectionCommand implements InputCommand {

    UP("w", movePoint(-1, 0), "W: 윗쪽으로 이동합니다."),
    DOWN("s", movePoint(1, 0), "S: 아랫쪽으로 이동합니다."),
    RIGHT("d", movePoint(0, 1), "D: 오른쪽으로 이동합니다."),
    LEFT("a", movePoint(0, -1), "A: 왼쪽으로 이동합니다."),
    IN_PLACE("in_place", movePoint(0, 0), "I: 가만히 있습니다.");

    private final String command;
    private final Point nextPosition;
    private final String description;

    DirectionCommand(String command, Point nextPosition, String description) {
        this.command = command;
        this.description = description;
        this.nextPosition = nextPosition;
    }

    public static DirectionCommand getDirectionCommands(String input) {
        return Stream.of(values())
                .filter(position -> position.command.toLowerCase().equals(input))
                .findAny()
                .orElseGet(() -> IN_PLACE);
    }

    public static List<String> getDirectionCommands() {
        return Stream.of(values())
                .map(DirectionCommand::getCommand)
                .map(String::toLowerCase)
                .sorted()
                .collect(Collectors.toList());
    }

    public String getCommand() {
        return command;
    }

    public Point getNextPosition() {
        return nextPosition;
    }
}
