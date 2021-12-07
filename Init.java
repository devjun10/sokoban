import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Init {
    private static final StringBuilder stringBuilder = new StringBuilder();
    private static StageInfo stageInfo = StageInfo.of();

    static {

    }

    static void initBoard() {
        List<Board> boards = new ArrayList<>();

    }

    static List<Board> getBoards(){
        List<String> lst = new ArrayList<>();
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

    static String joiningTextFileWord(){
        try {
            stringBuilder.setLength(0);
            File file = new File("map.txt");
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while ((line = bufReader.readLine()) != null) {
                while (line.length() < 6) {
                    line += " ";
                }
                stringBuilder.append(",").append(line);
            }
            bufReader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return stringBuilder.substring(1);
    }

    static int getMaxLength(){
        return 1;
    }

    private String[] splitByStage(String word){
        return word.split("==========");
    }

    public static void main(String[] args) {

        List<String> lst = new ArrayList<>();
        try {
            stringBuilder.setLength(0);
            File file = new File("map.txt");
            FileReader filereader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while ((line = bufReader.readLine()) != null) {
                while (line.length() < 6) {
                    line += " ";
                }
                stringBuilder.append(",");
                stringBuilder.append(line);
            }
            String word = stringBuilder.toString();
            word = word.substring(1);
            String[] words = word.split("==========");

            for(int i=0; i<words.length; i++){
                String[] sp = words[i].split(",");
            }
            bufReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

//        lst.forEach(word -> System.out.println(word.length()));
        Init init = new Init();
        System.out.println(joiningTextFileWord());
    }
}