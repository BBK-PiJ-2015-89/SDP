package Main;

/**
 * Created by graemewilkinson on 28/01/17.
 */
public class MotionSensor implements Sensor {

    @Override
    public boolean isTriggered() {
        return false;
    }

    @Override
    public String getLocation() {
        return null;
    }

    @Override
    public String getSensorType() {
        return null;
    }

    @Override
    public String getSensorCat() {
        return "Security";
    }
}
