package Main;

import java.util.ArrayList;
import java.util.List;

public class ControlUnit {
  private List<Sensor> sensors = new ArrayList<Sensor>();

  public ControlUnit(List<Sensor> sensorList){
    sensors = sensorList;
  }

  public void pollSensors() {

    for (Sensor sensor : sensors) {
      if (sensor.isTriggered()) {
        System.out.println("A " + sensor.getSensortype() + " sensor was triggered at " + sensor.getLocation());
      } else {
        System.out.println("Polled " + sensor.getSensortype() + " at " + sensor.getLocation() + " successfully");
      }
    }
  }
}
