package area;

import area.shapes.Shape;
import area.shapes.Rectangle;
import area.shapes.Circle;
import area.shapes.Trapezoid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Shape> shapes = new ArrayList<>();

        // 读取输入
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                break;
            }

            String[] parts = line.split("\\s+");//去空格
            char type = parts[0].charAt(0);

            switch (type) {
                case 'A': // 矩形
                    double width = Double.parseDouble(parts[1]);
                    double height = Double.parseDouble(parts[2]);
                    shapes.add(new Rectangle(width, height));
                    break;
                case 'B': // 圆形
                    double radius = Double.parseDouble(parts[1]);
                    shapes.add(new Circle(radius));
                    break;
                case 'C': // 梯形
                    double topBase = Double.parseDouble(parts[1]);
                    double bottomBase = Double.parseDouble(parts[2]);
                    double trapezoidHeight = Double.parseDouble(parts[3]);
                    shapes.add(new Trapezoid(topBase, bottomBase, trapezoidHeight));
                    break;
                default:
                    System.out.println("未知的形状类型: " + type);
            }
        }

        // 计算总面积
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }

        // 输出结果
        System.out.printf("%n%.2f%n", totalArea);
    }
}