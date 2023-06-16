package mk.ukim.finki.napredno.ispitni.prvkolokvium.sensoranalysis;

import java.util.ArrayList;
import java.util.List;

public class Sensor {
    String sensorID;
    IGeo location;
    List<Measurement> measurements;

    public Sensor(String sensorID, IGeo location, List<Measurement> measurements) {
        this.sensorID = sensorID;
        this.location = location;
        this.measurements = measurements;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "sensorID='" + sensorID + '\'' +
                '}';
    }

    public static Sensor createSensor(String line) throws BadMeasureException, BadSensorException {

        String[] parts = line.split("\\s+");
        String sensorID = parts[0];

        if (parts.length == 3) {
            throw new BadSensorException(sensorID);
        }

        IGeo location = new IGeo() {
            @Override
            public double getLatitude() {
                return Double.parseDouble(parts[1]);
            }

            @Override
            public double getLongitude() {
                return Double.parseDouble(parts[2]);
            }
        };
        List<Measurement> measurementList = new ArrayList<>();
        long toSkip = 3;
        for (String part : parts) {
            if (toSkip > 0) {
                toSkip--;
                continue;
            }

            Measurement measurement = Measurement.createMeasurement(part, sensorID);
            measurementList.add(measurement);
        }
        return new Sensor(sensorID, location, measurementList);
    }

    public double averageValue(){
        return 0.0;
    }
}
