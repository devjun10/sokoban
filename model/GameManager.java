package model;

import view.InputCommand;
import view.commands.MoveInputCommand;
import view.message.SystemMessage;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    public void sayHello() {
        System.out.println(SystemMessage.GREET);
    }

    public void sayGoodBye() {
        System.out.println(SystemMessage.CLEAR_CELEBRATION);
        System.out.println(SystemMessage.CELEBRATION);
    }

    public void sayTurnOff() {
        System.out.println(SystemMessage.BYE);
    }

    public void sayTurnCount(int value) {
        System.out.println(SystemMessage.TURN_COUNT + "" + value);
    }

    public void sayTurnClear(int value) {
        System.out.println(SystemMessage.BLANK + "" + SystemMessage.STAGE_INFO + "" + value + "" + SystemMessage.CLEAR + SystemMessage.BLANK);
    }

    public void sayTurnReset() {
        System.out.println(SystemMessage.TURN_RESET);
    }

    public void saySaveComplete() {
        System.out.println(SystemMessage.SAVE);
    }

    public void saySaveList() {
        System.out.println(SystemMessage.ASK_STAGE_NUMBER);
    }

    public void sayNoMap() {
        System.out.println(SystemMessage.SAY_NO_MAP);
    }

    public List<InputCommand> getCommand(List<String> direction) {
        List<InputCommand> directionInputCommands = new ArrayList<>();
        for (String s : direction) {
            InputCommand inputCommand = MoveInputCommand.getCommands(s);
            directionInputCommands.add(inputCommand);
        }
        return directionInputCommands;
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
}
