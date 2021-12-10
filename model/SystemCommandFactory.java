package model;

import model.commands.*;
import view.InputCommand;
import view.commands.DirectionInputCommand;
import view.commands.SystemInputCommand;

public class SystemCommandFactory {

    public static Command getCommand(InputCommand command){
        if(command.equals(DirectionInputCommand.UP)){
            return new Up();
        }
        if(command.equals(DirectionInputCommand.DOWN)){
            return new Down();
        }
        if(command.equals(DirectionInputCommand.LEFT)){
            return new Left();
        }
        if(command.equals(DirectionInputCommand.RIGHT)){
            return new Right();
        }
        if(command.equals(SystemInputCommand.C)){
            return new Save();
        }
        if(command.equals(SystemInputCommand.L)){
            return new Load();
        }
        return new Quit();
    }

}
