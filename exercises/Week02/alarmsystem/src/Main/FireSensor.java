package Main;

import java.util.Random;

/**
 * Created by graemewilkinson on 28/01/17.
 */
public class FireSensor implements SensorFireSmoke {
    private int batteryPerc = 100;
    private Random returnValue = new Random();
    String actualLocation = null;
    String actualSensorType = "Fire Sensor";

    public FireSensor (String location){
        actualLocation = location;
    }


    @Override
    public boolean isTriggered() {
        int triggerValue = returnValue.nextInt(100);
        return triggerValue < 5;
    }

    @Override
    public String getLocation() {
        return actualLocation;
    }

    @Override
    public String getSensortype() {
        return actualSensorType;
    }

    @Override
    public int getBatteryPercentage() {
        int tempBat = batteryPerc;
        batteryPerc = batteryPerc-10;
        return tempBat;
    }
}
