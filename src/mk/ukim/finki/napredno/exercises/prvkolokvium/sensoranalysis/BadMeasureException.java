package mk.ukim.finki.napredno.exercises.prvkolokvium.sensoranalysis;

public class BadMeasureException extends Exception {
    public BadMeasureException(int timestamp, String sensorId) {
        super(String.format("Error in timestamp: %d from sensor: %s",timestamp, sensorId));
    }
}
