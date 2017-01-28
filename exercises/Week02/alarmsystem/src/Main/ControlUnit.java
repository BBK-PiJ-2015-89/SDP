package Main;

import java.util.ArrayList;
import java.util.List;

public class ControlUnit {
  private List<SensorInt> sensors = new ArrayList<SensorInt>();

  public ControlUnit(List<SensorInt> sensorList){
    sensors = sensorList;
  }

  public void pollSensors() {

    for (SensorInt sensor : sensors) {
      if (sensor.isTriggered()) {
        System.out.println("A " + sensor.getSensortype() + " sensor was triggered at " + sensor.getLocation());
      } else {
        System.out.println("Polled " + sensor.getSensortype() + " at " + sensor.getLocation() + " successfully");
      }
    }
  }
}
