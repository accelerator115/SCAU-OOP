package AdditionPractice;

import java.util.*;

public class AdditionQuiz {
    private List<AdditionQuestion> questions;

    public AdditionQuiz(int n, int min, int max) {
        questions = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int a = rand.nextInt(max - min + 1) + min;
            int b = rand.nextInt(max - min + 1) + min;
            questions.add(new AdditionQuestion(a, b));
        }
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        int correctCount = 0;

        System.out.println("本次练习共有" + questions.size() + "个题目.\n");

        for (int i = 0; i < questions.size(); i++) {
            AdditionQuestion q = questions.get(i);
            System.out.print("题目" + (i + 1) + ": " + q.getQuestionText() + ", 输入你的答案: ");
            int answer = scanner.nextInt();

            if (q.isCorrect(answer)) {
                System.out.println("正确");
                correctCount++;
            } else {
                System.out.println("错误");
            }
        }

        System.out.println("一共做对了 " + correctCount + " 个题目！");
        scanner.close();
    }
}