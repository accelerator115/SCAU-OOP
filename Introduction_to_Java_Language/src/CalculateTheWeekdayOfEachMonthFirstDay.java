import java.util.*;

public class CalculateTheWeekdayOfEachMonthFirstDay {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        if (!in.hasNextInt()) {
            System.out.println("不正确的输入");
            return;
        }
        int year = in.nextInt();
        
        if (!in.hasNextInt()) {
            System.out.println("不正确的输入");
            return;
        }
        int first = in.nextInt();
        
        if (year <= 0) {
            System.out.println("不正确的输入");
            return;
        }
        
        if (first < 0 || first > 6) {
            System.out.println("不正确的输入");
            return;
        }
        
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            days[1] = 29;
        }

        int[] ans = new int[12];
        ans[0] = first;
        for (int i = 1; i < 12; i++) {
            ans[i] = (ans[i-1] + days[i-1]) % 7;
        }

        for (int i = 0; i < 12; i++) {
            System.out.print(ans[i]);
            if (i != 11) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}

