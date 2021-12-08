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

    int stageUp(int value) {
        return value += 1;
    }

    int plusTurn(int value) {
        return value + 1;
    }

    int turnInit() {
        return 0;
    }

    void turnOffTheGame() {
        System.exit(1);
    }

    void askStageNumber() {
        System.out.println(Message.ASK_STAGE_NUMBER);
    }

    List<StageData> getSlotData(GameMachine machine){
        return machine.getSlotData();
    }

    public void saySaveList() {
        System.out.println(Message.ASK_STAGE_NUMBER);
    }

    public void sayNoMap() {
        System.out.println(Message.SAY_NO_MAP);
    }
}
