package utils;

import static utils.Parser.changeIntSymbol;
import static utils.Parser.changeStringSymbol;

public class BoardUtils {

    public static int[][] copyIntArrayOriginal(int[][] array) {
        int[][] temp = new int[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                temp[row][col] = array[row][col];
            }
        }
        return temp;
    }

    public static int[][] convertStringArrayToIntArrayOriginal(String[][] array) {
        int[][] temp = new int[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                temp[row][col] = Integer.parseInt(array[row][col]);
            }
        }
        return temp;
    }

    public static int[][] convertStringArrayToIntArrayUsingSymbol(String[][] array) {
        int[][] temp = new int[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                temp[row][col] = changeStringSymbol(array[row][col]);
            }
        }
        return temp;
    }

    public static String[][] convertIntArrayToStringArrayUsingSymbol(int[][] array) {
        String[][] temp = new String[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                temp[row][col] = changeIntSymbol(array[row][col]);
            }
        }
        return temp;
    }
}
