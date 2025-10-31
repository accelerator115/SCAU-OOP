package appliance.device;

public abstract class ElectricalDevice {
    private String name;
    protected boolean isOn = false;

    public ElectricalDevice(String name) {
        this.name = name;
    }

    public abstract void powerOn();

    public abstract void powerOff();

    public String getStatus() {
        String status = isOn ? "开启" : "关闭";
        return "[" + name + "] 当前状态: " + status;
    }

    protected String getName() {
        return name;
    }
}