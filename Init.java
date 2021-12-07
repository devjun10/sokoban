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

    String joiningTextFileWord(){
        try {
            stringBuilder.setLength(0);
            File file = new File("map.txt");
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while ((line = bufReader.readLine()) != null) {
//                while (line.length() < maxValue) {
//                    line += " ";
//                }
                stringBuilder.append(line);
//                stringBuilder.append(",").append(line);
            }
            bufReader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return stringBuilder.toString();
    }

    private String[] splitByStage(String word){
        return word.split("==========");
    }

    private String[][] getMap(String[] words){
        String word = "999999\n900409\n929999\n909000\n919000\n999000";
        word = word.replaceAll("9", "#");
        word = word.replaceAll("0", " ");
        word = word.replaceAll("1", "O");
        word = word.replaceAll("2", "o");
        word = word.replaceAll("3", "0");
        word = word.replaceAll("4", "P");
        word = word.replaceAll("5", "P");
        return null;
    }

//    public static void main(String[] args) {
//        Init init = new Init();
//        System.out.println(init.joiningTextFileWord());
//        try {
//            stringBuilder.setLength(0);
//            File file = new File("map.txt");
//            FileReader filereader = new FileReader(file);
//            BufferedReader bufReader = new BufferedReader(filereader);
//            String line = "";
//            while ((line = bufReader.readLine()) != null) {
//                while (line.length() < 6) {
//                    line += " ";
//                }
//                stringBuilder.append(",");
//                stringBuilder.append(line);
//            }
//            String word = stringBuilder.toString();
//            word = word.substring(1);
//            String[] words = word.split("==========");
//
//            for(int i=0; i<words.length; i++){
//                String[] sp = words[i].split(",");
//            }
//            bufReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println(e);
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//    }

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