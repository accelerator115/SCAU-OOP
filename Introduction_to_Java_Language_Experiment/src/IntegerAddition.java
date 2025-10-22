import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class IntegerAddition {
    // 内部类表示加法题目
    static class AdditionProblem {
        int a, b;
        AdditionProblem(int a, int b) {
            this.a = a;
            this.b = b;
        }
        int getAnswer() {
            return a + b;
        }
        @Override
        public String toString() {
            return String.format("%d + %d = ?", a, b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入加法练习的题目数量: ");
        int n = sc.nextInt();
        System.out.print("输入加法练习的加数范围的最小值: ");
        int min = sc.nextInt();
        System.out.print("输入加法练习的加数范围的最大值: ");
        int max = sc.nextInt();

        ArrayList<AdditionProblem> problems = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int a = rand.nextInt(max - min + 1) + min;
            int b = rand.nextInt(max - min + 1) + min;
            problems.add(new AdditionProblem(a, b));
        }

        System.out.printf("本次练习共有%d个题目.\n", n);
        int correct = 0;
        for (int i = 0; i < n; i++) {
            AdditionProblem p = problems.get(i);
            System.out.printf("题目%d: %s, 输入你的答案: ", i + 1, p.toString());
            int ans = sc.nextInt();
            if (ans == p.getAnswer()) {
                System.out.println("正确");
                correct++;
            } else {
                System.out.println("错误");
            }
        }
        System.out.printf("一共做对了 %d 个题目！\n", correct);
        sc.close();
    }
}
