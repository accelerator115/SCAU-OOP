import java.util.Scanner;

public class ECalculater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n > 0) {
                double e = calculateE(n);
                System.out.printf("%.8f%n", e);
            } else {
                System.out.println("不正确的输入");
            }
        } else {
            System.out.println("不正确的输入");
        }
        scanner.close();
    }

    public static double calculateE(int n) {
        double e = 1.0;
        double factorial = 1.0;
        for (int i = 1; i <= n; i++) {
            factorial *= i; 
            e += 1.0 / factorial; 
        }
        return e;
    }
}