package model.commands;

import model.Command;
import view.InputCommand;
import view.commands.DirectionInputCommand;

public class Up implements Command {

    private final String command = "Up";

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
