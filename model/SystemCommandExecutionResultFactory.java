package model;

import model.commands.*;
import view.InputCommand;
import view.commands.DirectionCommand;
import view.commands.SystemInputCommand;

import java.util.List;

public class SystemCommandExecutionResultFactory {

    private static final List<Class<? extends Command>> commands
            = List.of(Down.class, Left.class, Load.class, Quit.class);

//    public static String getCommand(InputCommand command) throws Exception {
//            Class<? extends Command> clazz
//                    = commands.stream()
//                    .filter(x -> x.getSimpleName().equals(((DirectionInputCommand) command).getCommand()))
//                    .findAny().get();
//            Command getInstance = clazz.getConstructor().newInstance();
//            Method method = clazz.getMethod("execute", InputCommand.class);
//        return method.invoke(getInstance, );
//    }

    //    private String getMessage(Command command){
//        return "";
//    }
    public static Command getCommand(InputCommand command) throws Exception {
        if (command.equals(DirectionCommand.UP)) {
            return new Up();
        } else if (command.equals(DirectionCommand.DOWN)) {
            return new Down();
        } else if (command.equals(DirectionCommand.LEFT)) {
            return new Left();
        } else if (command.equals(DirectionCommand.RIGHT)) {
            return new Right();
        } else if (command.equals(SystemInputCommand.C)) {
            return new Save();
        } else if (command.equals(SystemInputCommand.L)) {
            return new Load();
        }
        return new Quit();
    }

}
