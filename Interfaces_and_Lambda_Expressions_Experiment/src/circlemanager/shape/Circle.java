// java
package circlemanager.shape;

public class Circle implements Colorable {
    private double x;
    private double y;
    private double radius;
    private String color;

    public Circle(double x, double y, double radius, String color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void howToColor() {
        System.out.printf("Circle (%.2f,%.2f) - %.2f - %s, 填充圆的内部%n",
                x, y, radius, color);
    }
}
