package model.commands;

import model.Command;
import view.InputCommand;
import view.commands.SystemInputCommand;

public class Reset implements Command {

    private final String command = "Reset";

    @Override
    public String execute(InputCommand inputCommand) {
        SystemInputCommand command = (SystemInputCommand) inputCommand;
        return command.getCommand();
    }

    @Override
    public String toString() {
        return command;
    }
}
