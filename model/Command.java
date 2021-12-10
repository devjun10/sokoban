package model;

import view.InputCommand;

public interface Command {
    String execute(InputCommand inputCommand);
}
