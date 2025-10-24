package calculator;

import calculator.exp.ArithmeticExpression;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArithmeticExpression expression = new ArithmeticExpression(input);
        System.out.println(expression.getResult());
        scanner.close();
    }
}
