import java.io.*;
import java.util.List;
import java.util.Objects;

public class Init {
    private static final StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        String a = null;
        String[][] arr = new String[2][2];
        arr[0][0] = null;
        arr[0][1] = "A";
        arr[1][0] = "B";
        arr[1][1] = "C";

        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
//                if(arr[i][j] !=null){
                if(arr[i][j] != null) continue;
                else arr[i][j] = Objects.requireNonNullElseGet("F", ()->"");
            }
        }

        for(int i=0; i<2; i++){
            System.out.println();
            for(int j=0; j<2; j++){
                System.out.print(arr[i][j]);
            }
        }
        System.out.println();

        try{
            //파일 객체 생성
            File file = new File("map.txt");
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while((line = bufReader.readLine()) != null){
                System.out.println(line);
            }
            //.readLine()은 끝에 개행문자를 읽지 않는다.
            bufReader.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }
    }
}