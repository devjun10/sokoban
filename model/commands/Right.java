package model.commands;

import model.Command;
import view.InputCommand;
import view.commands.DirectionCommand;

public class Right implements Command {

    private final String command = "Right";

    @Override
    public String execute(InputCommand inputCommand) {
        DirectionCommand command = (DirectionCommand) inputCommand;
        return command.getCommand();
    }

    @Override
    public String toString() {
        return command;
    }
}
