import java.util.List;

public class Main {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) throws Exception {
        GameMachine gameMachine = new GameMachine();
        GameManager manager = new GameManager();

        manager.sayHello();
        int stageNumber = 1;
        int turn = 0;

        while (stageNumber < 5) {
            Stage stage = gameMachine.getStage(stageNumber);
            outputView.initBoard(stage.getBoard());
            boolean flag = false;
            Loop1:
            while (stage.isNotAnswer()) {
                List<Command> commands = manager.getCommand(inputView.inputCommand());
                if (commands.get(0).equals(Command.R)) {
                    stage.resetStage();
                    turn = 0;
                    manager.sayTurnReset();
                    continue;
                }
                List<GameResult> result = gameMachine.play(stageNumber, commands);
                for (GameResult gameResult : result) {
                    if (gameResult.getBoard() == null) {
                        manager.sayTurnCount(turn);
                        manager.sayTurnOff();
                        manager.turnOffTheGame();
                    }

                    if(!flag)
                        turn = manager.plusTurn(turn);
                    if (stage.checkAnswer(gameResult.getBoard())) {
                        if (!flag) {
                            manager.sayTurnClear(stageNumber);
                            manager.sayTurnCount(turn);
                        }
                        flag = true;
                    }
                    if (!flag) {
                        manager.sayTurnCount(turn);
                        outputView.printBoard(gameResult);
                    }
                }
            }

            turn = manager.turnInit();
//            manager.sayTurnClear(stageNumber);
            stageNumber = manager.stageUp(stageNumber);
        }
        manager.sayGoodBye();
    }
}
