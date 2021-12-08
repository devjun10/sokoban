import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Slot {

    private List<StageData> saveData = new ArrayList<>();

    private Slot() {};

    public static Slot of() {
        return new Slot();
    }

    public void saveData(int stageNumber, int[][] array){
        File file = new File("save.txt");
        String stage = String.valueOf(stageNumber);
        String map = "";
        for(int row=0; row<array.length; row++){
            for(int col=0; col<array[0].length; col++){
                map+=array[row][col];
            }
            map+=",";
            map+="\n";
            System.out.println();
        }

        String saveData = stage+"\n"+map;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(saveData);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Slot slot = new Slot();
    }

    public StageData loadStageData(int stageNumber){
        return this.saveData.stream()
                .filter(stage->stage.getStage()==stageNumber)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }


    int[][] copyBoard(int[][] array) {
        int[][] temp = new int[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            temp[row] = array[row].clone();
        }
        return temp;
    }
}
