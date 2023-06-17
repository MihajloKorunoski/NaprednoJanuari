package mk.ukim.finki.napredno.ispitni.prvkolokvium.sensoranalysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GeoSensorApplication {

    List<Sensor> sensors;

    public GeoSensorApplication() {
        sensors = new ArrayList<>();
    }

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

    public double averageValue(){
        return sensors.stream()
                .mapToDouble(Sensor::getAverageValue)
                .average()
                .orElse(0.0);
    }

    public double averageDistanceValue(IGeo location, double distance, long timeFrom, long timeTo) {
        return 0.0;
    }

    public List<ExtremeValue> extremeValues(long timeFrom, long timeTo) {

        return new ArrayList<>();
    }
}
