package model.commands;

import model.Command;
import view.GameResult;
import view.InputCommand;
import view.commands.SystemInputCommand;

public class Quit implements Command {

    @Override
    public GameResult execute(InputCommand inputCommand) {
        SystemInputCommand systemCommand = (SystemInputCommand) inputCommand;
        GameResult result = new GameResult();
//        inputMessage(result, systemCommand.getCommand());
        return result;
    }
}
