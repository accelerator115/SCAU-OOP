package ClosestFarthestPoints;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("需要输入的坐标个数: ");
        int n = scanner.nextInt();

        Set<Point> points = new HashSet<>();
        for (int i = 0; i < n; i++) {
            System.out.printf("请输入第 %d 个点的坐标 (格式: x y): ", i + 1);
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points.add(new Point(x, y));
        }

        List<Point> pointList = new ArrayList<>(points);
        if (pointList.size() < 2) {
            System.out.println("需要至少两个不同的点来计算最近和最远距离。");
            return;
        }
        pointList.sort(Comparator.comparingDouble(Point::getX)
                .thenComparingDouble(Point::getY));

        System.out.println("实际共有： " + pointList.size() + " 个不同的点。");
        System.out.println(pointList);

        double minDistance = Double.MAX_VALUE;
        double maxDistance = Double.MIN_VALUE;
        List<Point> closestPoints = new ArrayList<>();
        List<Point> farthestPoints = new ArrayList<>();

        for (int i = 0; i < pointList.size(); i++) {
            for (int j = i + 1; j < pointList.size(); j++) {
                Point p1 = pointList.get(i);
                Point p2 = pointList.get(j);
                double distance = Math.hypot(p1.getX() - p2.getX(), p1.getY() - p2.getY());

                if (distance < minDistance) {
                    minDistance = distance;
                    closestPoints.clear();
                    closestPoints.add(p1);
                    closestPoints.add(p2);
                } else if (distance == minDistance) {
                    closestPoints.add(p1);
                    closestPoints.add(p2);
                }

                if (distance > maxDistance) {
                    maxDistance = distance;
                    farthestPoints.clear();
                    farthestPoints.add(p1);
                    farthestPoints.add(p2);
                } else if (distance == maxDistance) {
                    farthestPoints.add(p1);
                    farthestPoints.add(p2);
                }
            }
        }

        System.out.printf("距离最近：%s，距离是：%.2f\n", closestPoints, minDistance);
        System.out.printf("距离最远：%s，距离是：%.2f\n", farthestPoints, maxDistance);
    }
}
