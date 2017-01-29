package Tests;

import Main.ControlUnit;
import Main.FireSensor;
import Main.Sensor;
import Main.SmokeSensor;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class ControlUnitTest {
    List<Sensor> sensors = new ArrayList<Sensor>();
    ControlUnit controller = new ControlUnit(sensors);

    @Before
    public void setUp()
    {
        List<Sensor> sensors = new ArrayList<Sensor>();
        sensors.add(new FireSensor("Living Room"));
        sensors.add(new SmokeSensor("Loft"));
    }

}
