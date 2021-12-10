package model;

import view.InputCommand;
import view.message.SystemMessage;

import java.util.ArrayList;
import java.util.List;

import static utils.InputUtils.stringBuilder;
import static view.commands.DirectionInputCommand.getDirectionCommands;
import static view.commands.SystemInputCommand.getSystemInputCommand;
import static view.commands.SystemInputCommand.getSystemInputCommands;

public class GameManager {

    private final int zero = 0;
    private final int one = 1;
    private final List<String> systemCommands;
    private final List<String> directionCommands;

    public GameManager() {
        systemCommands = getSystemInputCommands();
        directionCommands = getDirectionCommands();
    }

    public void sayHello() {
        stringBuilder.setLength(zero);
        System.out.println(SystemMessage.GREET);
    }

    public void sayGoodBye() {
        stringBuilder.setLength(zero);
        stringBuilder.append(SystemMessage.CLEAR_CELEBRATION).append("\n")
                .append(SystemMessage.CELEBRATION);
        System.out.println(stringBuilder);
    }

    public void sayTurnOff() {
        stringBuilder.setLength(zero);
        System.out.println(SystemMessage.BYE);
    }

    public void sayTurnCount(int value) {
        stringBuilder.setLength(zero);
        stringBuilder.append(SystemMessage.TURN_COUNT).append(value);
        System.out.println(stringBuilder);
    }

    public void sayTurnClear(int value) {
        stringBuilder.setLength(zero);
        stringBuilder.append(SystemMessage.ENTER)
                .append(SystemMessage.STAGE_INFO).append(value)
                .append(SystemMessage.CLEAR)
                .append(SystemMessage.ENTER);
        System.out.println(stringBuilder);
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

    public List<InputCommand> getCommand(List<String> inputCommands) {
        List<InputCommand> commands = new ArrayList<>();
        for (String inputCommand : inputCommands) {
            if (this.directionCommands.contains(inputCommand)) {
                commands.add(getDirectionCommands(inputCommand));
            } else {
                System.out.println(getSystemInputCommand(inputCommand));
                commands.add(getSystemInputCommand(inputCommand));
            }
        }
        return commands;
    }

    public int plusCount(int value) {
        return value + one;
    }

    public int turnInit() {
        return zero;
    }

    public void turnOffTheGame() {
        System.exit(one);
    }

    public List<StageData> getSlotData(GameMachine machine) {
        return machine.getSlotData();
    }
}
