import java.util.Scanner;

public class LockerProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n > 0) {
                boolean[] lockers = new boolean[n + 1]; 
                for (int person = 1; person <= n; person++) {
                    for (int locker = person; locker <= n; locker += person) {
                        lockers[locker] = !lockers[locker]; 
                    }
                }
                for (int i = 1; i <= n; i++) {
                    if (lockers[i]) {
                        System.out.print(i + " ");
                    }
                }
                System.out.println();
            } else {
                System.out.println("不正确的输入");
            }
        } else {
            System.out.println("不正确的输入");
        }
        scanner.close();
    }
}