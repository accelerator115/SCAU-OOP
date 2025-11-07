package appliance.device;

public class Light extends ElectricalDevice {
    public Light(String name) {
        super(name);
    }

    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("电灯[" + getName() + "]已点亮");
    }

    @Override
    public void powerOff() {
        isOn = false;
        System.out.println("电灯[" + getName() + "]已关闭");
    }
}