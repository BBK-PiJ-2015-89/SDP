package Main;

import java.util.Random;

/**
 * Created by graemewilkinson on 28/01/17.
 */
public class SmokeSensor implements SensorInt {
    private int batteryPerc = 100;
    String location = null;
    String actualSensorType = "Smoke Sensor";
    private Random returnValue = new Random();

    public SmokeSensor (String location){
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
    public String getSensortype() {
        return actualSensorType;
    }

    @Override
    public int getBatteryPercentage() {
        int tempBat = batteryPerc;
        batteryPerc = batteryPerc-20;
        return tempBat;
    }
}
