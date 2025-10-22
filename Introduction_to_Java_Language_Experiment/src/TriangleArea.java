public class TriangleArea {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();

        double a = Math.hypot(x1 - x2, y1 - y2);
        double b = Math.hypot(x2 - x3, y2 - y3);
        double c = Math.hypot(x3 - x1, y3 - y1);

        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

        System.out.printf("area=%.2f\n", area);
        scanner.close();
    }
}
