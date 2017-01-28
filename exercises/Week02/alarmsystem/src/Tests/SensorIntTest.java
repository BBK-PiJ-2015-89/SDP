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
    String smokeDetectorLocation = "Loft";
    SensorInt smoke = new SmokeSensor(smokeDetectorLocation);
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

    @Test
    public void smokecheckDrainage() throws Exception {
        int currentBattery = 100;
        for (int i = 0; i <= 10; i++) {
            currentBattery = smoke.getBatteryPercentage();
        }
        Assert.that(currentBattery == 0, "drained");
    }

    @Test
    public void smokecheckTriggers() throws Exception {
        int numberOfTriggers = 0;
        for (int i = 0; i < 10000; i++){
            if(smoke.isTriggered()){
                numberOfTriggers++;
            }
        }
        System.out.println(numberOfTriggers);
        Assert.that(numberOfTriggers<1100 && numberOfTriggers>900, "Triggers equal 10%");
    }

    @Test
    public void smokelocationCheck() throws Exception{
        Assert.that(smoke.getLocation().equals("Loft"), "check we are in the loft");
    }

    @Test
    public void smokeTypeTest() throws Exception {
        Assert.that(smoke.getSensortype().equals("Smoke Sensor"), "should be a smoke sensor");
    }
}
