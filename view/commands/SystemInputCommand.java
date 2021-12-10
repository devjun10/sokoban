package view.commands;

import view.InputCommand;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum SystemInputCommand implements InputCommand {

    R("r", "R: 스테이지를 초기화합니다. "),
    C("c", "S: 현재 진행상황을 저장합니다."),
    L("l", "L: 세이브에서 진행상황을 불러옵니다"),
    Q("q", "Bye~");

    private final String command;
    private final String description;

    SystemInputCommand(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public static SystemInputCommand getSystemInputCommand(String input) {
        return Stream.of(values())
                .filter(position -> position.command.toLowerCase().equals(input))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public static List<String> getSystemInputCommands() {
        return Stream.of(values())
                .map(SystemInputCommand::getCommand)
                .map(String::toLowerCase)
                .sorted()
                .collect(Collectors.toList());
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "SystemInputCommand[" +
                "command='" + command + '\'' +
                ", description='" + description + '\'' +
                ']';
    }
}
