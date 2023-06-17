package mk.ukim.finki.napredno.ispitni.prvkolokvium.sensoranalysis;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GeoSensorApplication {

    List<Sensor> sensors;
    public void readGeoSensors(Scanner s) throws BadSensorException, BadMeasureException {
        while(s.hasNextLine()){
            String line = s.nextLine();
            sensors.add(Sensor.createSensor(line));
        }
    }

    public List<Sensor> inRange(IGeo location, double dis) {
        return sensors.stream()
                .filter(sensor -> sensor.location.distance(location) < dis)
                .collect(Collectors.toList());
    }

    public boolean averageValue() {
        return false;
    }

    public boolean averageDistanceValue(IGeo iGeo, double dis, long t1, long t2) {
        return false;
    }

    public boolean extremeValues(long t1, long t2) {
        return false;
    }
}
