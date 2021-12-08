import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Init {

    private static final StringBuilder stringBuilder = new StringBuilder();
    private static final StageInformationList STAGE_INFORMATION_LIST = StageInformationList.of();
    private  AES256Cipher aes256Cipher = AES256Cipher.getInstance();

    {
        List<StageInformation> information = STAGE_INFORMATION_LIST.getStageInformation();
        List<String[][]> maps = null;
        try {
            maps = getMaps();
        } catch (InvalidAlgorithmParameterException | UnsupportedEncodingException | NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException | InvalidKeyException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 4; i++) {
            Board board = new Board(changeStringArrayToIntegerArray(maps.get(i)));
            StageInformation info = information.get(i);
            Stages.putStage(i + 1, info, board);
        }
    }

    private static int[][] changeStringArrayToIntegerArray(String[][] array) {
        int[][] temp = new int[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                temp[row][col] = Integer.parseInt(array[row][col]);
            }
        }
        return temp;
    }

    private Init() {};

    public static Init of() {
        return new Init();
    }

    List<String[][]> getMaps() throws InvalidAlgorithmParameterException, UnsupportedEncodingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        String[][] result = getStages();
        List<String[][]> answer = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            String[] temp = result[i];
            String[][] array = new String[temp.length][temp[0].length()];
            for (int j = 0; j < temp.length; j++) {
                array[j] = temp[j].split("");
            }
            answer.add(array);
        }
        return answer;
    }

    String[][] getStages() throws InvalidAlgorithmParameterException, UnsupportedEncodingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        String[] eachStages = joiningTextFileWord();
        int rows = eachStages.length;
        String[][] result = new String[rows][];

        for (int i = 0; i < rows; i++) {
            String[] temp = splitByComma(eachStages[i]);
            int tempCols = temp.length;
            result[i] = new String[tempCols];
            for (int j = 0; j < tempCols; j++) {
                result[i][j] = temp[j];
            }
        }
        return result;
    }

    private String[] splitByComma(String word) {
        return word.split(",");
    }

    static String[] joiningTextFileWord() throws InvalidAlgorithmParameterException, UnsupportedEncodingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        try {
            stringBuilder.setLength(0);
            File file = new File("map_enc.txt");
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
        return splitByStage(AES256Cipher.AES_Decode(stringBuilder.toString()));
    }

    private static String[] splitByStage(String word) {
        return word.split("==========");
    }
}




