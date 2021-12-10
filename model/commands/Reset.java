package model.commands;

import model.Command;
import view.GameResult;
import view.InputCommand;

public class Reset implements Command {
    @Override
    public GameResult execute(InputCommand inputCommand) {
        return null;
    }

    @Override
    public void inputMessage(GameResult gameResult, String message) {
        gameResult.addMesage(message);
    }
}
