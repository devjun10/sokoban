public class Answer {

    private int[][] answer;

    public Answer(int[][] answer) {
        this.answer = answer;
    }

    public int[][] getAnswer() {
        return answer;
    }

//    public boolean checkAnswer(int[][] board) {
//        for (int row = 0; row < board.length; row++) {
//            for (int col = 0; col < board[0].length; col++) {
//                if (board[row][col].equals(this.answer[row][col])) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
}
