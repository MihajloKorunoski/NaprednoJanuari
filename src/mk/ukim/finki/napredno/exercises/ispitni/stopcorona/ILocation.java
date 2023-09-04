package mk.ukim.finki.napredno.exercises.ispitni.stopcorona;

import java.time.LocalDateTime;

interface ILocation{
    double getLongitude();

    double getLatitude();

    LocalDateTime getTimestamp();
}
