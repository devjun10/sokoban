public class Answer {

    private String[][] answer;

    public Answer(String[][] answer) {
        this.answer = answer;
    }

    public String[][] getAnswer() {
        return answer;
    }

    public boolean checkAnswer(String[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col].equals(this.answer[row][col])) {
                    return false;
                }
            }
        }
        return true;
    }
}
