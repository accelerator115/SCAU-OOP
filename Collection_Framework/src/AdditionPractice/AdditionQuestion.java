package AdditionPractice;

public class AdditionQuestion {
    private int a;
    private int b;

    public AdditionQuestion(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String getQuestionText() {
        return a + " + " + b + " = ?";
    }

    public int getCorrectAnswer() {
        return a + b;
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == getCorrectAnswer();
    }
}