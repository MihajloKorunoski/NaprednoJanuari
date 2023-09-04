package mk.ukim.finki.napredno.exercises.prvkolokvium.weatherstation;

import java.util.*;
import java.util.stream.Collectors;

class WeatherStation {
    List<Measurement> measurements;
    int days;

    public WeatherStation(int days) {
        this.days = days;
        measurements = new ArrayList<>();
    }

    public void addMeasurement(float temperature, float wind, float humidity, float visibility, Date date) {
        long now = date.getTime();
        measurements.removeIf(m -> (now - m.date.getTime()) > days * 24 * 60 * 60 * 1000L);

        boolean isCloseTimestamp = measurements.stream()
                .anyMatch(m -> Math.abs(m.date.getTime() - date.getTime()) < 2.5 * 60 * 1000L);
        if (!isCloseTimestamp)
            measurements.add(new Measurement(temperature, wind, humidity, visibility, date));
    }

    public int total() {
        return measurements.size();
    }

    public void status(Date from, Date to) {
        List<Measurement> filtered = measurements.stream()
                .filter(m -> !m.date.before(from) && !m.date.after(to))
                .sorted(Comparator.comparing(m -> m.date))
                .collect(Collectors.toList());

        if (filtered.isEmpty())
            throw new RuntimeException();

        filtered.forEach(m -> System.out.printf("%.1f %.1f km/h %.1f%% %.1f km %s\n",
                m.temperature, m.wind, m.humidity, m.visibility, m.date));

        OptionalDouble optionalAverage = filtered.stream()
                .mapToDouble(m -> m.temperature)
                .average();
        double averageTemperature = optionalAverage.orElse(0.0);

        System.out.printf("Average temperature: %.2f\n", averageTemperature);
    }
}
