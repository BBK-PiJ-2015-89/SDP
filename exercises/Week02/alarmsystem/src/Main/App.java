package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final String EXIT = "exit";
    private static final String POLL = "poll";

    public static void main(String[] args) throws IOException {
        List<Sensor> sensors = new ArrayList<Sensor>();
        sensors.add(new FireSensor("Living Room"));
        sensors.add(new SmokeSensor("Loft"));
        List<Sensor> sensorsSecurity = new ArrayList<Sensor>();
        sensorsSecurity.add(new MotionSensor("Basement"));

        ControlUnit controlUnit = new ControlUnit(sensors);
        SecurityControlUnit securityUnit = new SecurityControlUnit(sensorsSecurity);


        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equals(EXIT)) {
            System.out.println("Type \"poll\" to poll all sensors once or \"exit\" to exit");
            input = scanner.nextLine();
            if (input.equals(POLL)) {
                controlUnit.pollSensors();
                securityUnit.pollSensors();
            }
        }
    }
}
