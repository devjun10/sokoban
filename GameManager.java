import java.util.ArrayList;
import java.util.List;

public class GameManager {

    public List<Command> getCommand(List<String> direction) {
        List<Command> commands = new ArrayList<>();
        for (int i = 0; i < direction.size(); i++) {
            Command command = Command.getDirection(direction.get(i));
            commands.add(command);
        }
        return commands;
    }
}
