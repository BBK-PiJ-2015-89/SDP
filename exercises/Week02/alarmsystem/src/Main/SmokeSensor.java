package Main;

import java.util.Random;

/**
 * Created by graemewilkinson on 28/01/17.
 */
public class SmokeSensor implements SensorInt {
    String location = null;
    private Random returnValue = new Random();
    public SmokeSensor (String location){
        location = this.location;
    }

    @Override
    public boolean isTriggered() {
        int triggerValue = returnValue.nextInt(100);
        return triggerValue < 10;
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
