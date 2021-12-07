public class Answer {

    private int[][] answer;

    private int[][] original;

    public Answer(int[][] array) {
        this.original = array;
        this.answer = calculateAnswer(array);
    }

    public static void main(String[] args) throws Exception {
        Board b = Board.of();
        int[][] bb = b.copyBoard();
        Answer answers = new Answer(bb);

        int[][] answer = b.getAnswer();
        System.out.println("====================");
        for (int row = 0; row < answer.length; row++) {
            System.out.println();
            for (int col = 0; col < answer[0].length; col++) {
                System.out.print(answer[row][col]);
            }
        }

        System.out.println(b);
        System.out.println();
        System.out.println("====================");
        answers.isAnswer(bb);
        System.out.println(answers.isAnswer(bb));
        System.out.println(answers.isAnswer(answer));



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
            if (checkColumn(row, map[row])) {
                return false;
            }
        }
        return true;
    }


    public boolean checkColumn(int row, int[] array) {
        for (int col = 0; col < array.length; col++) {
            if (array[col] != this.answer[row][col]) {
                return true;
            }
        }
        return false;
    }

    public int[][] getAnswer() {
        int[][] temp = new int[answer.length][answer[0].length];
        for (int row = 0; row < answer.length; row++) {
            temp[row] = this.answer[row].clone();
        }
        return temp;
    }

    private int[][] deleteCharacter(int array[][]) {
        int[][] temp = new int[answer.length][answer[0].length];
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
}
