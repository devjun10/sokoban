import model.*;

public class Main {
    public static void main(String[] args) throws Exception {
        GameManager manager = new GameManager();
        while (manager.getCurrentStageNumber() < manager.getFinalStageNumber()) {
            manager.startGame();
            manager.proceedGame();
        }
        manager.sayGoodBye();
    }
}
