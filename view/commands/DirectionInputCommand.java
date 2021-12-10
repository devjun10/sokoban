package view.commands;

import view.InputCommand;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum DirectionInputCommand implements InputCommand {

    UP("w", "W: 윗쪽으로 이동합니다.", List.of(-1, 0)),
    DOWN("s", "S: 아랫쪽으로 이동합니다.", List.of(1, 0)),
    RIGHT("d", "D: 오른쪽으로 이동합니다.", List.of(0, 1)),
    LEFT("a", "A: 왼쪽으로 이동합니다.", List.of(0, -1));

    private final String command;
    private final String description;
    private final List<Integer> nextPosition;

    DirectionInputCommand(String command, String description, List<Integer> nextPosition) {
        this.command = command;
        this.description = description;
        this.nextPosition = nextPosition;
    }

    public static DirectionInputCommand getDirectionCommands(String input) {
        return Stream.of(values())
                .filter(position -> position.command.toLowerCase().equals(input))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public static List<String> getDirectionCommands() {
        return Stream.of(values())
                .map(DirectionInputCommand::getCommand)
                .map(String::toLowerCase)
                .sorted()
                .collect(Collectors.toList());
    }

    public String getCommand() {
        return command;
    }

    public List<Integer> getNextPosition() {
        return nextPosition;
    }

}
