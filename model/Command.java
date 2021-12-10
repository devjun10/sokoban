package model;

import view.GameResult;
import view.InputCommand;

public interface Command {
    GameResult execute(InputCommand inputCommand);

}
