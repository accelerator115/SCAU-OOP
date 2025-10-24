import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个正整数：");
        String input = scanner.nextLine();
        if (!input.matches("[1-9]\\d*")) {
            System.out.println("不正确的输入");
            return;
        }
        int len = input.length();
        boolean flag = true;
        for (int i = 0; i < len / 2; i++) {
            if (input.charAt(i) != input.charAt(len - i - 1)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println(input + "是回文整数");
        } else {
            System.out.println(input + "不是回文整数");
        }
    }
}