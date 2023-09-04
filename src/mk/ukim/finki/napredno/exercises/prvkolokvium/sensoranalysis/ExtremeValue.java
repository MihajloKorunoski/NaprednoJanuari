package mk.ukim.finki.napredno.exercises.prvkolokvium.sensoranalysis;

public class ExtremeValue {
    String sensorID;
    double minValue;
    double maxValue;

    public ExtremeValue(String sensorID, double minValue, double maxValue) {
        this.sensorID = sensorID;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public String toString() {
        return "ExtremeValue{" +
                "sensorID='" + sensorID + '\'' +
                ", minValue=" + minValue +
                ", maxValue=" + maxValue +
                '}';
    }
}
