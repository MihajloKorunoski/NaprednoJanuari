package mk.ukim.finki.napredno.ispitni.prvkolokvium.sensoranalysis;

public class Measurement {
    int timestamp;
    double value;

    public Measurement(int timestamp, double value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public static Measurement createMeasurement(String data, String sensorID) throws BadMeasureException {
        String[] parts = data.split(":");
        int timestamp = Integer.parseInt(parts[0]);
        double value = Double.parseDouble(parts[1]);
        if (value < 0){
            throw new BadMeasureException(timestamp,sensorID);
        }
        return new Measurement(timestamp,value);
    }
}
