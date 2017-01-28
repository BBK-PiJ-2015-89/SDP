package Main;

/**
 * Created by graemewilkinson on 28/01/17.
 */
public class SmokeSensor implements SensorInt {
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
        return 0;
    }
}
