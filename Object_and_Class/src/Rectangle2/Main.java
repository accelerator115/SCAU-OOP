package Rectangle2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double width = scanner.nextDouble();
        double height = scanner.nextDouble();

        Rectangle defaultRectangle = new Rectangle();
        System.out.printf("%.2f,%.2f%n", defaultRectangle.getPerimeter(), defaultRectangle.getArea());

        Rectangle customRectangle = new Rectangle(width, height);
        System.out.printf("%.2f,%.2f%n", customRectangle.getPerimeter(), customRectangle.getArea());

        scanner.close();
    }
}