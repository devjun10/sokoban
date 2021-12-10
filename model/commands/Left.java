package model.commands;

import model.Command;
import view.InputCommand;
import view.commands.DirectionInputCommand;

public class Left implements Command {

    private final String command = "Left";

    @Override
    public String  execute(InputCommand inputCommand) {
        DirectionInputCommand command = (DirectionInputCommand) inputCommand;
        return command.getCommand();
    }

    @Override
    public String toString() {
        return command;
    }
}
