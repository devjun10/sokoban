import java.util.ArrayList;
import java.util.List;

public class Slot {

    private List<int[][]> slot = new ArrayList<>();

    private Slot (){};

    public static Slot of() {
        return new Slot();
    }

    public void save(int number, int[][] board){
        slot.remove(number-1);
        slot.add(number-1, board);
    }

    public static void main(String[] args) throws Exception {
        List<String> lst = new ArrayList<>();
        lst.add("A");
        lst.add("B");
        lst.add("C");
        lst.add("D");
        lst.add("E");
        lst.remove(1);
        lst.forEach(System.out::println);
    }

//    public void save(int[][] board){
//        slot.add(board);
//    }
}
