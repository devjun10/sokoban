package model;

import java.util.List;

import static view.commands.DirectionCommand.getDirectionCommands;
import static view.commands.SystemInputCommand.getSystemInputCommands;

public class CommandList {
    private final List<String> systemCommands;
    private final List<String> directionCommands;

    CommandList(){
        systemCommands = getSystemInputCommands();
        directionCommands = getDirectionCommands();
    }

    public List<String> getDirectionCommands() {
        return directionCommands;
    }
}
