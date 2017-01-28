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

    SensorInt smoke = new SmokeSensor();
    SensorInt fire = new FireSensor();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void checkDrainage() throws Exception {
        int currentBattery = 100;
        for (int i = 0; i <= 10; i++) {
            currentBattery = fire.getBatteryPercentage();
        }
        Assert.that(currentBattery == 0, "drained");
    }

    @Test
    public void checkTriggers() throws Exception {
        int numberOfTriggers = 0;
        for (int i = 0; i < 100; i++){
            if(fire.isTriggered()){
                numberOfTriggers++;
            }
        }
        Assert.that(numberOfTriggers==5, "Triggers equal 5%");
    }
}
