package mk.ukim.finki.napredno.exercises.prvkolokvium.sensoranalysis;

public class BadSensorException extends Exception{
    public BadSensorException(String sensorID) {
        super(String.format("No readings from sensor %s", sensorID));

    }
}
