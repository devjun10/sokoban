import java.util.ArrayList;
import java.util.List;

public class Slot {

    private List<int[][]> slot = new ArrayList<>();

    private Slot() {};

    public static Slot of() {
        return new Slot();
    }

    public void save(int number, int[][] board) {
        slot.remove(number - 1);
        slot.add(number - 1, board);
    }

    public int[][] load(int number) {
        int[][] array = slot.get(number - 1);
        int[][] copy = copyBoard(array);
        return copy;
    }

    int[][] copyBoard(int[][] array) {
        int[][] temp = new int[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            temp[row] = array[row].clone();
        }
        return temp;
    }
}
