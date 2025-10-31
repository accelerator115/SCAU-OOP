package regularpolygon.shape;

public class RegularPolygon {
    private int numberOfSides = 3;
    private double lengthOfSide = 1.0;
    private double x = 0.0;
    private double y = 0.0;

    // 无参构造方法
    public RegularPolygon() {

    }

    // 指定边数和边长的构造方法
    public RegularPolygon(int numberOfSides, double lengthOfSide) {
        this.numberOfSides = numberOfSides;
        this.lengthOfSide = lengthOfSide;
    }

    // 指定边数、边长和中心点的构造方法
    public RegularPolygon(int numberOfSides, double lengthOfSide, double x, double y) {
        this.numberOfSides = numberOfSides;
        this.lengthOfSide = lengthOfSide;
        this.x = x;
        this.y = y;
    }

    // 访问器和修改器
    public int getNumberOfSides() {
        return numberOfSides;
    }

    public void setNumberOfSides(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public double getLengthOfSide() {
        return lengthOfSide;
    }

    public void setLengthOfSide(double lengthOfSide) {
        this.lengthOfSide = lengthOfSide;
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

    public double getArea() {
        return (numberOfSides * Math.pow(lengthOfSide, 2)) / (4 * Math.tan(Math.PI / numberOfSides));
    }

    public double getOffset() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return String.format("[%d,%.2f]@(%.2f,%.2f)", numberOfSides, lengthOfSide, x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RegularPolygon that = (RegularPolygon) obj;
        return numberOfSides == that.numberOfSides &&
                Double.compare(that.lengthOfSide, lengthOfSide) == 0 &&
                Double.compare(that.x, x) == 0 &&
                Double.compare(that.y, y) == 0;
    }

    // 覆盖 hashCode 方法
    @Override
    public int hashCode() {
        int result = Integer.hashCode(numberOfSides);
        long temp;
        temp = Double.doubleToLongBits(lengthOfSide);
        result = 31 * result + Long.hashCode(temp);
        temp = Double.doubleToLongBits(x);
        result = 31 * result + Long.hashCode(temp);
        temp = Double.doubleToLongBits(y);
        result = 31 * result + Long.hashCode(temp);
        return result;
    }
}