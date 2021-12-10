package view.commands;

import view.InputCommand;

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

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }
}
