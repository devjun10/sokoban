import java.util.ArrayList;
import java.util.List;

public class GameManager {

    public void sayHello() {
        System.out.println(Message.GREET);
    }

    public void sayGoodBye() {
        System.out.println(Message.CLEAR_CELEBRATION);
        System.out.println(Message.CELEBRATION);
    }

    public void sayTurnCount(int value) {
        System.out.println(Message.TURN_COUNT + "" + value);
    }

    public void sayTurnClear(int value) {
        System.out.println(Message.BLANK + "" + Message.STAGE_INFO + "" + value + "" + Message.CLEAR + Message.BLANK);
    }

    public List<Command> getCommand(List<String> direction) {
        List<Command> commands = new ArrayList<>();
        for (int i = 0; i < direction.size(); i++) {
            Command command = Command.getDirection(direction.get(i));
            if(command.equals(Command.R)){
                return List.of(Command.R);
            }
            validateQuit(command);
            commands.add(command);
        }
        return commands;
    }

    public int stageUp(int value) {
        return value += 1;
    }

    public int plusTurn(int value) {
        return value;
    }

    public int turnInit() {
        return 0;
    }

    private void validateQuit(Command command) {
        if (command.getCommand().equals("q")) {
            System.out.println();
            System.out.println(command.getDescription());
            System.exit(1);
        }
    }

    public void sayTurnReset() {
        System.out.println(Message.TURN_RESET);
    }
}
