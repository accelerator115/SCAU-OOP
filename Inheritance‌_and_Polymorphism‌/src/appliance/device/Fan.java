package appliance.device;

public class Fan extends ElectricalDevice {
    private int speed = 1;

    public Fan(String name) {
        super(name);
    }

    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("风扇[" + getName() + "]已启动, 当前风速: [" + speed + "]级");
    }

    @Override
    public void powerOff() {
        isOn = false;
        System.out.println("风扇[" + getName() + "]已停止");
    }

    public void adjustSpeed(int newSpeed) {
        if (isOn && newSpeed >= 1 && newSpeed <= 3) {
            speed = newSpeed;
            System.out.println("风扇[" + getName() + "]风速已调整为[" + newSpeed + "]级");
        }
    }
}