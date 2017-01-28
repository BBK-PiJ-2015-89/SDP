package Main;

import java.util.Random;

/**
 * Created by graemewilkinson on 28/01/17.
 */
public class MotionSensor implements Sensor {

    String location = null;
    String actualSensorType = "Motion Detector";
    private Random returnValue = new Random();

    public MotionSensor (String location){
        this.location = location;
    }

    @Override
    public boolean isTriggered() {
        int triggerValue = returnValue.nextInt(100);
        return triggerValue < 10;
    }

    @Override
    public String getLocation() {

        return location;
    }

    @Override
    public String getSensorType() {
        return actualSensorType;
    }

    @Override
    public String getSensorCat() {
        return "Security";
    }

}
