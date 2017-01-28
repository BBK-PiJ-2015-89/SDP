package Main;

import java.util.ArrayList;
import java.util.List;

public class ControlUnit {

  public void pollSensors() {
    List<SensorInt> sensors = new ArrayList<SensorInt>();
    sensors.add(new FireSensor("Living Room"));
    sensors.add(new SmokeSensor("Loft"));

    for (SensorInt sensor : sensors) {
      if (sensor.isTriggered()) {
        System.out.println("A " + sensor.getSensortype() + " sensor was triggered at " + sensor.getLocation());
      } else {
        System.out.println("Polled " + sensor.getSensortype() + " at " + sensor.getLocation() + " successfully");
      }
    }
  }
}
