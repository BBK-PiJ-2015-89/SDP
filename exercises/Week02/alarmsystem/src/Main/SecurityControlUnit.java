package Main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by graemewilkinson on 28/01/17.
 */
public class SecurityControlUnit extends ControlUnit {

    public SecurityControlUnit(List<Sensor> sensorList) {
        super(sensorList);
    }

    public void pollSensors(){
        if(timeCheck()){
            super.pollSensors();
        }
    }

    public boolean timeCheck() {
        String timeStamp = new SimpleDateFormat("HHmm").format(Calendar.getInstance().getTime());
        int result = Integer.parseInt(timeStamp);
        return result > 2159 || result < 601;
    }
}
