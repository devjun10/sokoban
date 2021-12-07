public class Answer {

    private int[][] answer;

    private int[][] original;

    public Answer(int[][] array) {
        this.original = array;
        this.answer = calculateAnswer(array);
    }

    private int[][] calculateAnswer(int[][] array) {
        int[][] temp = new int[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                temp[row][col] = changeNumber(array[row][col]);
            }
        }
        return temp;
    }

    private int changeNumber(int value) {
        if (value == 1) return 3;
        if (value == 2) return 0;
        if (value == 4) return 0;
        return value;
    }

    public boolean isAnswer(int[][] array) {
        int[][] map = deleteCharacter(array);
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

    public int[][] getOriginal() {
        int[][] temp = new int[original.length][original[0].length];
        for (int row = 0; row < original.length; row++) {
            for (int col = 0; col < original[0].length; col++) {
                temp[row][col] = original[row][col];
            }
        }
        return temp;
    }

    private int[][] deleteCharacter(int[][] array) {
        int[][] temp = new int[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                temp[row][col] = changeCharacter(array[row][col]);
            }
        }
        return temp;
    }

    private int changeCharacter(int value) {
        if (value == 4) {
            return 0;
        }
        return value;
    }


    public boolean checkAnswer(String[][] arry) {
        return false;
    }
}
