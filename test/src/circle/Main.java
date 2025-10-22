package circle;

import circle.shape.Circle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double r1 = scanner.nextDouble();
        Circle circle1 = new Circle(x1, y1, r1);

        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double r2 = scanner.nextDouble();
        Circle circle2 = new Circle(x2, y2, r2);

        if (circle1.contains(circle2)) {
            System.out.printf("(%1.2f,%1.2f)-%1.2f 包含 (%1.2f,%1.2f)-%1.2f%n",
                    x1, y1, r1, x2, y2, r2);
        } else if (circle2.contains(circle1)) {
            System.out.printf("(%1.2f,%1.2f)-%1.2f 包含 (%1.2f,%1.2f)-%1.2f%n",
                    x2, y2, r2, x1, y1, r1);
        } else if (circle1.intersects(circle2)) {
            System.out.printf("(%1.2f,%1.2f)-%1.2f 与 (%1.2f,%1.2f)-%1.2f 相交%n",
                    x1, y1, r1, x2, y2, r2);
        } else if (circle1.separates(circle2)) {
            System.out.printf("圆(%1.2f,%1.2f)-%1.2f 与 圆(%1.2f,%1.2f)-%1.2f 无关%n",
                    x1, y1, r1, x2, y2, r2);
        }

        scanner.close();
    }
}