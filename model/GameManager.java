package model;

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
import static utils.Number.ONE;
import static utils.Number.ZERO;
import static view.commands.DirectionCommand.getDirectionCommands;
import static view.commands.StageProgress.CLEAR;
import static view.commands.StageProgress.NOT_CLEAR;
import static view.commands.SystemInputCommand.getSystemInputCommand;
import static view.commands.SystemInputCommand.getSystemInputCommands;

public class GameManager {

    private final List<String> systemCommands;
    private final List<String> directionCommands;
    private final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private final GameMachine gameMachine = new GameMachine();
    StageProgress progressState = NOT_CLEAR;

    private int turn = 0;
    private int currentStageNumber = 1;
    private int finalStageNumber = 5;

    public GameManager() {
        systemCommands = getSystemInputCommands();
        directionCommands = getDirectionCommands();
    }

    public void proceedGame() throws Exception {
        sayHello();
        Stage currentStage = gameMachine.getStage(currentStageNumber);

        while (currentStageNumber < finalStageNumber) {
            showMap(currentStage);
            play(currentStage);
            stageClear();
        }
        sayGoodBye();
    }

    public void sayHello() {
        stringBuilder.setLength(ZERO.getIntvalue());
        System.out.println(SystemMessage.GREET);
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
        return value + ONE.getIntvalue();
    }

    public int turnInit() {
        return ZERO.getIntvalue();
    }

    public void validateGameOff(GameResult gameResult) {
        if (gameResult.getMessage().equals(SystemInputCommand.Q.getCommand())) {
            sayTurnCount(turn);
            sayTurnOff();
            System.exit(ONE.getIntvalue());
        }
    }

    public List<StageData> getSlotData() {
        return gameMachine.getSlotData();
    }

    public void showList(List<StageData> data) {
        data.forEach(System.out::println);
    }

    private void play(Stage currentStage) throws Exception {
        while (currentStage.isNotAnswer()) {
            List<InputCommand> inputCommands = getCommand(inputView.inputCommand());
            List<GameResult> results = gameMachine.play(this.currentStageNumber, inputCommands);
            executeResult(currentStage, results);
        }
    }

    private void executeResult(Stage currentStage, List<GameResult> results) {
        for (GameResult executionResult : results) {
            validateGameOff(executionResult);
            if (isCommandL(executionResult)) {
                showSavedList(currentStage);
                break;
            } else if (isCommandR(executionResult)) {
                reset(currentStage);
                break;
            } else if (isCommandC(executionResult)) {
                save(currentStage);
                continue;
            }
            updateStageInformation(currentStage, progressState, executionResult);
        }
    }

    private void showMap(Stage currentStage) {
        outputView.printBoard(currentStage.getBoard());
    }

    private void updateStageInformation(Stage currentStage, StageProgress progressState, GameResult result) {
        if (currentStage.checkAnswer(result.getBoard())) {
            if (progressState.equals(NOT_CLEAR)) {
                sayTurnClear(this.currentStageNumber);
                sayTurnCount(turn);
            }
            progressState = CLEAR;
        }
        if (progressState.equals(NOT_CLEAR)) {
            turn = plusCount(turn);
            sayTurnCount(turn);
            outputView.printGameResult(result);
        }
    }

    private void reset(Stage stage) {
        stage.resetMap();
        turn = 0;
        sayTurnReset();
        outputView.printBoard(stage.getBoard());
    }

    private void showSavedList(Stage currentStage) {
        List<StageData> data = showSlotList();

        String inputStage = inputView.inputStage();
        int inputStageNumber = Integer.parseInt(inputStage.substring(0, 1));

        if (!data.get(inputStageNumber - 1).getName().equals("Empty")) {
            currentStage = gameMachine.loadSlotData(inputStageNumber);
            this.currentStageNumber = currentStage.getStageNumber();
            outputView.printBoard(currentStage.getBoard());
            turn = turnInit();
        } else {
            sayNoMap();
            outputView.printBoard(currentStage.getBoard());
        }
    }

    private List<StageData> showSlotList() {
        List<StageData> data = getSlotData();
        showList(data);
        saySaveList();
        return data;
    }

    private void save(Stage stage) {
        saySaveComplete();
        currentStageNumber = stage.getStageNumber();
        gameMachine.saveStage(currentStageNumber);
        outputView.printBoard(stage.getBoard());
    }

    private boolean isCommandC(GameResult gameResult) {
        return gameResult.getMessage().equals(SystemInputCommand.C.getCommand());
    }

    private boolean isCommandR(GameResult gameResult) {
        return gameResult.getMessage().equals(SystemInputCommand.R.getCommand());
    }

    private boolean isCommandL(GameResult gameResult) {
        return gameResult.getMessage().equals(SystemInputCommand.L.getCommand());
    }

    public int getCurrentStageNumber() {
        return this.currentStageNumber;
    }

    private void stageClear() {
        turn = turnInit();
        gameMachine.clearStage(currentStageNumber);
        currentStageNumber = plusCount(currentStageNumber);
    }

    public void sayGoodBye() {
        stringBuilder.setLength(ZERO.getIntvalue());
        stringBuilder.append(SystemMessage.CLEAR_CELEBRATION).append("\n")
                .append(SystemMessage.CELEBRATION);
        System.out.println(stringBuilder);
    }
}
