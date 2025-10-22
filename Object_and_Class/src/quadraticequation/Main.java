package quadraticequation;

import quadraticequation.equation.QuadraticEquation;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        if (a == 0) {
            System.out.println("不是一元二次方程");
        } else {
            double discriminant = equation.getDiscriminant();

            if (discriminant < 0) {
                System.out.println("方程没有实根");
            } else if (discriminant == 0) {
                System.out.printf("方程有2个相等的实根:%.2f%n", equation.getRoot1());
            } else {
                System.out.printf("方程有2个不等的实根:%.2f和%.2f%n", equation.getRoot1(), equation.getRoot2());
            }
        }

        scanner.close();
    }
}