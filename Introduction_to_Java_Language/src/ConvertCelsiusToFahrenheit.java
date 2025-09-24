import java.util.*;

public class ConvertCelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double C = in.nextDouble();
        double F = C * 9 / 5 + 32;
        System.out.printf("%.2f", F);
    }
}

