package model.commands;

import model.Command;
import view.InputCommand;
import view.commands.DirectionCommand;

public class Down implements Command {

    private final String command = "Down";

    @Override
    public String execute(InputCommand inputCommand) {
        DirectionCommand command = (DirectionCommand) inputCommand;
        return command.getCommand();
    }

    public Down getDown(){
        return new Down();
    }

    public String getCommand() {
        return command;
    }

    @Override
    public String toString() {
        return command;
    }
}
