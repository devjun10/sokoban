package model;

import utils.Number;
import view.GameResult;
import view.InputCommand;
import view.InputView;
import view.OutputView;
import view.commands.StageProgress;
import view.commands.SystemInputCommand;
import view.message.SystemMessage;

import java.util.ArrayList;
import java.util.List;

import static utils.InputUtils.stringBuilder;
import static utils.Number.ZERO;
import static view.commands.DirectionCommand.getDirectionCommands;
import static view.commands.SystemInputCommand.getSystemInputCommand;
import static view.commands.SystemInputCommand.getSystemInputCommands;

public class GameManager {

    private final int zero = 0;
    private final int one = 1;
    private final List<String> systemCommands;
    private final List<String> directionCommands;
    private final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private final GameMachine gameMachine = new GameMachine();

    private int stageNumber = 1;
    private int turn = 0;

    public GameManager() {
        systemCommands = getSystemInputCommands();
        directionCommands = getDirectionCommands();
    }

    public void sayHello() {
        stringBuilder.setLength(ZERO.getIntvalue());
        System.out.println(SystemMessage.GREET);
    }

    public void sayGoodBye() {
        stringBuilder.setLength(ZERO.getIntvalue());
        stringBuilder.append(SystemMessage.CLEAR_CELEBRATION).append("\n")
                .append(SystemMessage.CELEBRATION);
        System.out.println(stringBuilder);
    }

    public void sayTurnOff() {
        stringBuilder.setLength(ZERO.getIntvalue());
        System.out.println(SystemMessage.BYE);
    }

    public void sayTurnCount(int value) {
        stringBuilder.setLength(ZERO.getIntvalue());
        stringBuilder.append(SystemMessage.TURN_COUNT).append(value);
        System.out.println(stringBuilder);
    }

    public void sayTurnClear(int value) {
        stringBuilder.setLength(ZERO.getIntvalue());
        stringBuilder.append(SystemMessage.ENTER)
                .append(SystemMessage.STAGE_INFO).append(value)
                .append(SystemMessage.CLEAR)
                .append(SystemMessage.ENTER);
        System.out.println(stringBuilder);
    }

    public void sayTurnReset() {
        stringBuilder.setLength(ZERO.getIntvalue());
        System.out.println(SystemMessage.TURN_RESET);
    }

    public void saySaveComplete() {
        stringBuilder.setLength(ZERO.getIntvalue());
        System.out.println(SystemMessage.SAVE);
    }

    public void saySaveList() {
        stringBuilder.setLength(ZERO.getIntvalue());
        System.out.println(SystemMessage.ASK_STAGE_NUMBER);
    }

    public void sayNoMap() {
        stringBuilder.setLength(ZERO.getIntvalue());
        System.out.println(SystemMessage.SAY_NO_MAP);
    }

    public List<InputCommand> getCommand(List<String> inputCommands) {
        List<InputCommand> commands = new ArrayList<>();
        for (String inputCommand : inputCommands) {
            if (this.directionCommands.contains(inputCommand)) {
                commands.add(getDirectionCommands(inputCommand));
                continue;
            }
            commands.add(getSystemInputCommand(inputCommand));
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

    public void showList(List<StageData> data) {
        data.forEach(System.out::println);
    }

    public void proceedGame() throws Exception {
        sayHello();

        while (stageNumber < 5) {
            Stage stage = gameMachine.getStage(stageNumber);
            StageProgress currentStageProgress = StageProgress.NOT_CLEAR;
            outputView.printBoard(stage.getBoard());

            while (stage.isNotAnswer()) {
                List<InputCommand> inputCommands = getCommand(inputView.inputCommand());
                List<GameResult> result = gameMachine.play(stageNumber, inputCommands);

                for (GameResult gameResult : result) {

                    if (gameResult.getMessage().equals(SystemInputCommand.L.getCommand())) {
                        List<StageData> data = getSlotData(gameMachine);

                        showList(data);
                        saySaveList();

                        String inputStage = inputView.inputStage();
                        int inputStageNumber = Integer.parseInt(inputStage.substring(0, 1));

                        if (!data.get(inputStageNumber - 1).getName().equals("Empty")) {
                            stage = gameMachine.loadSlotData(inputStageNumber);
                            stageNumber = stage.getStageNumber();
                            outputView.printBoard(stage.getBoard());
                            turn = turnInit();
                        } else {
                            sayNoMap();
                            outputView.printBoard(stage.getBoard());
                        }
                        break;
                    }

                    if (gameResult.getMessage().equals(SystemInputCommand.R.getCommand())) {
                        stage.resetStage();
                        turn = 0;
                        sayTurnReset();
                        outputView.printBoard(stage.getBoard());
                        break;
                    }

                    if (gameResult.getMessage().equals(SystemInputCommand.Q.getCommand())) {
                        sayTurnCount(turn);
                        sayTurnOff();
                        turnOffTheGame();
                    }

                    if (gameResult.getMessage().equals(SystemInputCommand.C.getCommand())) {
                        saySaveComplete();
                        stageNumber = stage.getStageNumber();
                        gameMachine.saveStage(stageNumber);
                        outputView.printBoard(stage.getBoard());
                        continue;
                    }

                    if (stage.checkAnswer(gameResult.getBoard())) {
                        if (currentStageProgress.equals(StageProgress.NOT_CLEAR)) {
                            sayTurnClear(stageNumber);
                            sayTurnCount(turn);
                        }
                        currentStageProgress = StageProgress.CLEAR;
                    }

                    if (currentStageProgress.equals(StageProgress.NOT_CLEAR)) {
                        turn = plusCount(turn);
                        sayTurnCount(turn);
                        outputView.printGameResult(gameResult);
                    }
                }
            }
            stageClear();
        }
        sayGoodBye();
    }

    public int getStageNumber() {
        return this.stageNumber;
    }

    private void stageClear(){
        turn = turnInit();
        gameMachine.clearStage(stageNumber);
        stageNumber = plusCount(stageNumber);
    }
}
