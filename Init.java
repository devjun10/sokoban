import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Init {
    private static final StringBuilder stringBuilder = new StringBuilder();

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
        String word = null;
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
            word = stringBuilder.substring(1);
            bufReader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return word;
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

        lst.forEach(word -> System.out.println(word.length()));
    }
}