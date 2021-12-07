import java.util.List;

public class Main {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) throws Exception {
        Numbers numbers = new Numbers();
        GameMachine gameMachine = new GameMachine();
        GameManager manager = new GameManager();

        manager.sayHello();
        int stageNumber = 1;

        while (true) {
            Stage stage = gameMachine.getStage(stageNumber);
            while (true) {
                List<Command> commands = manager.getCommand(inputView.inputCommand());
                GameResult result = gameMachine.play(commands);
            }
        }

//        Stage stage = Stages.of().getStage(1);
//
//        String[][] array = stage.board();
//        for (int row = 0; row < array.length; row++) {
//            System.out.println();
//            for (int col = 0; col < array[0].length; col++) {
//                System.out.print(array[row][col]);
//            }
//        }
    }
}
