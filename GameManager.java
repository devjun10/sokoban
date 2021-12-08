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

    public void sayTurnOff() {
        System.out.println(Message.BYE);
    }

    public void sayTurnCount(int value) {
        System.out.println(Message.TURN_COUNT + "" + value);
    }

    public void sayTurnClear(int value) {
        System.out.println(Message.BLANK + "" + Message.STAGE_INFO + "" + value + "" + Message.CLEAR + Message.BLANK);
    }

    public void sayTurnReset() {
        System.out.println(Message.TURN_RESET);
    }

    public void askLoadSavedData() {
        System.out.print(Message.ASK_LOAD_STAGE_DATA);
    }

    public void saySaveComplete() {
        System.out.println(Message.SAVE);
    }

    public List<Command> getCommand(List<String> direction) {
        List<Command> commands = new ArrayList<>();
        for (int i = 0; i < direction.size(); i++) {
            Command command = Command.getCommands(direction.get(i));
            commands.add(command);
        }
        return commands;
    }

    public int stageUp(int value) {
        return value += 1;
    }

    public int plusTurn(int value) {
        return value + 1;
    }

    public int turnInit() {
        return 0;
    }

    public void turnOffTheGame() {
        System.exit(1);
    }

    public void askSaveData() {
        System.out.println(Message.SAVE_DATA);
    }

    public void askStageNumber() {
        System.out.println(Message.ASK_STAGE_NUMBER);

    }
}
