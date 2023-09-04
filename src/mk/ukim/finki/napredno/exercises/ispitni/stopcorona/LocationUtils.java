package mk.ukim.finki.napredno.exercises.ispitni.stopcorona;

import java.time.Duration;

class LocationUtils {
    public static double timeBetweenInSeconds(ILocation location1, ILocation location2) {
        return Math.abs(Duration.between(location1.getTimestamp(), location2.getTimestamp()).getSeconds());
    }

    public static double distanceBetween(ILocation location1, ILocation location2) {
        return Math.sqrt(Math.pow(location1.getLatitude() - location2.getLatitude(), 2)
                + Math.pow(location1.getLongitude() - location2.getLongitude(), 2));
    }

    public static boolean isDanger(ILocation location1, ILocation location2) {
        return distanceBetween(location1, location2) <= 2.0 && timeBetweenInSeconds(location1, location2) <= 300;
    }

    public static int dangerContactsBetween(User u1, User u2) {
        int counter = 0;
        for (ILocation location : u1.getLocations())
            for (ILocation location2 : u2.getLocations())
                if (isDanger(location, location2))
                    counter++;
        return counter;
    }
}
