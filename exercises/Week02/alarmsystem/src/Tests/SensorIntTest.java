package Tests;

import Main.FireSensor;
import Main.SensorInt;
import Main.SmokeSensor;
import org.junit.Before;
import org.junit.Test;
import sun.jvm.hotspot.utilities.Assert;

/**
 * Created by graemewilkinson on 28/01/17.
 */
public class SensorIntTest{

    String fireSensorLocation = "Living Room";
    SensorInt smoke = new SmokeSensor();
    SensorInt fire = new FireSensor(fireSensorLocation);

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void firecheckDrainage() throws Exception {
        int currentBattery = 100;
        for (int i = 0; i <= 10; i++) {
            currentBattery = fire.getBatteryPercentage();
        }
        Assert.that(currentBattery == 0, "drained");
    }

    @Test
    public void firecheckTriggers() throws Exception {
        int numberOfTriggers = 0;
        for (int i = 0; i < 10000; i++){
            if(fire.isTriggered()){
                numberOfTriggers++;
            }
        }
        System.out.println(numberOfTriggers);
        Assert.that(numberOfTriggers<520 && numberOfTriggers>480, "Triggers equal 5%");
    }

    @Test
    public void firelocationCheck() throws Exception{
       Assert.that(fire.getLocation().equals("Living Room"), "Check we are in the living room");
    }

    @Test
    public void fireTypeTest() throws Exception {
        Assert.that(fire.getSensortype().equals("Fire Sensor"), "It should be a fire sensor");
    }
}
