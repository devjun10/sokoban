public class GameManager {

    public Command getCommand(String direction) {
        return Command.getDirection(direction);
    }
}
