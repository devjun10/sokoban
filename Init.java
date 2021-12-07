import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Init {
    private static final StringBuilder stringBuilder = new StringBuilder();
    private final static StageInfo stageInfo = StageInfo.of();

    static {

    }

    static void initBoard() {
        List<Board> boards = new ArrayList<>();

    }

    static List<Board> getBoards(){
        try {
            stringBuilder.setLength(0);
            File file = new File("map.txt");
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while ((line = bufReader.readLine()) != null) {
                stringBuilder.append(line);
//                while (line.length() < 6) {
//                    line += " ";
//                }
//                String[] temp = line.split("");
//                lst.add(Arrays.asList(temp).stream()
//                        .collect(Collectors.joining()));
            }
            System.out.println(stringBuilder);
            bufReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    String[] joiningTextFileWord(){
        try {
            stringBuilder.setLength(0);
            File file = new File("map.txt");
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while ((line = bufReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            bufReader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return splitByStage(stringBuilder.toString());
    }

    private String[] splitByStage(String word){
        return word.split("==========");
    }

    private String[][] getMap(String word, int id){
        StageInformation info = stageInfo.getInformation(id);
        String[][] stringArray = new String[info.getHeight()][info.getWidth()];

        return null;
    }

    private String[] get(String word){
        word = word.replaceAll("9", "#");
        word = word.replaceAll("0", " ");
        word = word.replaceAll("1", "O");
        word = word.replaceAll("2", "o");
        word = word.replaceAll("3", "0");
        word = word.replaceAll("4", "P");
        word = word.replaceAll("5", "P");
        return null;
    }

    public static void main(String[] args) throws Exception {
        String word = "999999\n900409\n929999\n909000\n919000\n999000";
        word = word.replaceAll("9", "#");
        word = word.replaceAll("0", " ");
        word = word.replaceAll("1", "O");
        word = word.replaceAll("2", "o");
        word = word.replaceAll("3", "0");
        word = word.replaceAll("4", "P");
        word = word.replaceAll("5", "P");
        System.out.println(word);

    }


}