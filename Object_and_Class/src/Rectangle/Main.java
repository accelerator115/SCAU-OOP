package Rectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double width = scanner.nextDouble();
        double height = scanner.nextDouble();

        Rectangle rectangle = new Rectangle(width, height);

        System.out.printf("%.2f, %.2f%n", rectangle.getPerimeter(), rectangle.getArea());

        scanner.close();
    }
}