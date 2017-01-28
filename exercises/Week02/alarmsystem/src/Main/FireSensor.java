package Main;

/**
 * Created by graemewilkinson on 28/01/17.
 */
public class FireSensor implements SensorInt {

    private int batteryPerc = 100;

    @Override
    public boolean isTriggered() {
        return false;
    }

    @Override
    public String getLocation() {
        return null;
    }

    @Override
    public String getSensortype() {
        return null;
    }

    @Override
    public int getBatteryPercentage() {
        int tempBat = batteryPerc;
        batteryPerc = batteryPerc-10;
        return tempBat;
    }
}
