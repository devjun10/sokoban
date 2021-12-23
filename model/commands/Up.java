package model.commands;

import model.Command;
import view.InputCommand;
import view.commands.DirectionCommand;

public class Up implements Command {

    private final String command = "Up";

    @Override
    public String  execute(InputCommand inputCommand) {
        DirectionCommand command = (DirectionCommand) inputCommand;
        return command.getCommand();
    }

    @Override
    public String toString() {
        return command;
    }
}
