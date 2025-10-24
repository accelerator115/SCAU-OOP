package fan.data;

public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;

    private int speed;
    private boolean on;
    private String brand;

    public Fan(String brand) {
        this.speed = SLOW;
        this.on = false;
        this.brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        var brand = this.brand;
        var on = this.on ? "是" : "否";
        var speed = this.speed == 1 ? "慢" : this.speed == 2 ? "中" : "快";
        return "品牌:" + brand + "\n运行:" + on + "\n速度:" + speed;
    }
}
