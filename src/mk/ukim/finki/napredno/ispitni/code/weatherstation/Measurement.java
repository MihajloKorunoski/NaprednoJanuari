package mk.ukim.finki.napredno.ispitni.code.weatherstation;

import java.util.Date;

class Measurement {

    protected float temperature;
    protected float wind;
    protected float humidity;
    protected float visibility;
    protected Date date;

    public Measurement(float temperature, float wind, float humidity, float visibility, Date date) {
        this.temperature = temperature;
        this.wind = wind;
        this.humidity = humidity;
        this.visibility = visibility;
        this.date = date;
    }


}
