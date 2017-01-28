package Main;

/**
 * Created by graemewilkinson on 28/01/17.
 */
public interface SensorInt {

    /**
     * returns true/false for whether the sensor is triggered or not. Different sensors have different rules applied to them.
     * @return boolean
     */
    boolean isTriggered();

    /**
     * returns a description of the location of the sensor such as Lobby
     1st floor or In the auditorium.
     * @return String
     */
    String getLocation();

    /**
     *
     * @return returns a textual description of thesensor type such as"Fire sensor"
    or "Smoke sensor".
     */
    String getSensortype();

    /**
     *
     * @return Returns a number between 0-100 where 0 is empty and 100 is fully charged
     */
    int getBatteryPercentage();

}
