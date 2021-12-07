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

    public List<Command> getCommand(List<String> direction) {
        List<Command> commands = new ArrayList<>();
        for (int i = 0; i < direction.size(); i++) {
            Command command = Command.getDirection(direction.get(i));
            validateQuit(command);
            commands.add(command);
        }
        return commands;
    }

    private void validateQuit(Command command) {
        if (command.getCommand().equals("q")) {
            System.out.println();
            System.out.println(command.getDescription());
            System.exit(1);
        }
    }

    public List<GameResult> manageResult(List<GameResult> results) {
        List<GameResult> addResult = new ArrayList<>();


        return null;
    }
}
