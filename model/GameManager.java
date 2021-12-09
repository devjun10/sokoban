package model;

import view.Command;
import view.ManageMessage;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    public void sayHello() {
        System.out.println(ManageMessage.GREET);
    }

    public void sayGoodBye() {
        System.out.println(ManageMessage.CLEAR_CELEBRATION);
        System.out.println(ManageMessage.CELEBRATION);
    }

    public void sayTurnOff() {
        System.out.println(ManageMessage.BYE);
    }

    public void sayTurnCount(int value) {
        System.out.println(ManageMessage.TURN_COUNT + "" + value);
    }

    public void sayTurnClear(int value) {
        System.out.println(ManageMessage.BLANK + "" + ManageMessage.STAGE_INFO + "" + value + "" + ManageMessage.CLEAR + ManageMessage.BLANK);
    }

    public void sayTurnReset() {
        System.out.println(ManageMessage.TURN_RESET);
    }

    public void saySaveComplete() {
        System.out.println(ManageMessage.SAVE);
    }

    public List<Command> getCommand(List<String> direction) {
        List<Command> commands = new ArrayList<>();
        for (String s : direction) {
            Command command = Command.getCommands(s);
            commands.add(command);
        }
        return commands;
    }

    public int plusCount(int value) {
        return value+1;
    }

    public int turnInit() {
        return 0;
    }

    public void turnOffTheGame() {
        System.exit(1);
    }

    public List<StageData> getSlotData(GameMachine machine){
        return machine.getSlotData();
    }

    public void saySaveList() {
        System.out.println(ManageMessage.ASK_STAGE_NUMBER);
    }

    public void sayNoMap() {
        System.out.println(ManageMessage.SAY_NO_MAP);
    }
}
