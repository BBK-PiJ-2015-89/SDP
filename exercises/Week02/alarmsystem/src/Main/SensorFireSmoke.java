package Main;

/**
 * Created by graemewilkinson on 28/01/17.
 */
public interface SensorFireSmoke extends Sensor {
    /**
     *
     * @return Returns a number between 0-100 where 0 is empty and 100 is fully charged
     */
    int getBatteryPercentage();
}
