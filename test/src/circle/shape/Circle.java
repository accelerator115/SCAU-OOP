package circle.shape;

public class Circle {
    private double x;
    private double y;
    private double radius;

    public Circle() {
        this(0.0, 0.0, 1.0);
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
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

    public boolean contains(Circle other) {
        double distance = Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
        return distance + other.radius <= this.radius;
    }

    public boolean intersects(Circle other) {
        double distance = Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
        return distance < this.radius + other.radius && distance > Math.abs(this.radius - other.radius);
    }

    public boolean separates(Circle other) {
        double distance = Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
        return distance > this.radius + other.radius;
    }
}