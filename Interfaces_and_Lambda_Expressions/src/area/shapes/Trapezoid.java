package area.shapes;

public class Trapezoid extends Shape {
    private double topBase;
    private double bottomBase;
    private double height;

    public Trapezoid(double topBase, double bottomBase, double height) {
        this.topBase = topBase;
        this.bottomBase = bottomBase;
        this.height = height;
    }

    @Override
    public double getArea() {
        return (topBase + bottomBase) * height / 2;
    }
}
