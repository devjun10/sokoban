package model;

import static utils.BoardUtils.copyIntArrayOriginal;

public class Answer {

    private int[][] answer;

    private int[][] original;

    public Answer(int[][] array) {
        this.original = array;
        this.answer = changeSymbol(array);
    }

    private int[][] changeSymbol(int[][] array) {
        int[][] temp = new int[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                temp[row][col] = changeIntSymbol(array[row][col]);
            }
        }
        return temp;
    }

    private int changeIntSymbol(int value) {
        if (value == 1) return 3;
        if (value == 2) return 0;
        if (value == 4) return 0;
        return value;
    }

    boolean isAnswer(int[][] array) {
        int[][] map = deleteOnlyCharacter(array);
        int[][] answer = this.answer;
        for (int row = 0; row < answer.length; row++) {
            if(checkColumn(row, map[row])){
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int row, int[] array){
        for(int col=0; col<answer[0].length; col++){
            if(array[col] != this.answer[row][col]){
                return true;
            }
        }
        return false;
    }

    public int[][] getOriginalBoard() {
        return copyIntArrayOriginal(original);
    }

    private int[][] deleteOnlyCharacter(int[][] array) {
        int[][] temp = new int[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                temp[row][col] = changeCharacterIntSymbol(array[row][col]);
            }
        }
        return temp;
    }

    private int changeCharacterIntSymbol(int value) {
        if (value == 4) {
            return 0;
        }
        return value;
    }
}
