package fan;

import java.util.Scanner;
import fan.data.Fan;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入品牌:");
        String brand = scanner.nextLine();
        Fan fan = new Fan(brand);
        System.out.println(fan.toString());
        fan.setOn(true);
        System.out.println(fan.toString());
        fan.setSpeed(3);
        System.out.println(fan.toString());
        scanner.close();
    }
}
