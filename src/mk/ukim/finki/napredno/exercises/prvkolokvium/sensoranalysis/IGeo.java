package mk.ukim.finki.napredno.exercises.prvkolokvium.sensoranalysis;

public interface IGeo {
    double getLatitude();

    double getLongitude();

    default double distance(IGeo other) {
        return Math.sqrt(Math.pow(this.getLatitude() - other.getLatitude(), 2)
                + Math.pow(this.getLongitude() - other.getLongitude(), 2));
    }
}
