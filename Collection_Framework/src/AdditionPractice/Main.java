package AdditionPractice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("输入加法练习的题目数量: ");
        int n = scanner.nextInt();

        System.out.print("输入加法练习的加数范围的最小值: ");
        int min = scanner.nextInt();

        System.out.print("输入加法练习的加数范围的最大值: ");
        int max = scanner.nextInt();

        AdditionQuiz quiz = new AdditionQuiz(n, min, max);
        quiz.startQuiz();

        scanner.close();
    }
}