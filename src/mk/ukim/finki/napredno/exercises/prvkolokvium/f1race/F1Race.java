package mk.ukim.finki.napredno.exercises.prvkolokvium.f1race;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class F1Race {

    private List<Driver> drivers;

    public F1Race() {
        this.drivers = new ArrayList<>();
    }

    public void readResults(InputStream in) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = bf.readLine()) != null) {
                String[] tokens = line.trim().split("\\s+");
                String driverName = tokens[0];

                List<Long> times = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    times.add(parseTime(tokens[i + 1]));
                }

                drivers.add(new Driver(driverName, times));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Long parseTime(String token) {
        String[] parts = token.split(":");
        return Long.parseLong(parts[0]) * 60 * 1000 +
                Long.parseLong(parts[1]) * 1000 +
                Long.parseLong(parts[2]);
    }

    public void printSorted(OutputStream out) {
        PrintWriter pw = new PrintWriter(out);

        List<Driver> sortedDrivers = drivers.stream()
                .sorted(getDriverComparator())
                .collect(Collectors.toList());


        for (int i = 0; i < sortedDrivers.size(); i++) {
            pw.printf("%d. %-10s %9s\n", i + 1,
                    sortedDrivers.get(i).getName(),
                    formatTime(sortedDrivers.get(i).getBestTime()));
        }
        pw.flush();
    }

    private Object formatTime(long timeInMilis) {
        long minutes = timeInMilis / (60 * 1000);
        long seconds = (timeInMilis / 1000) % 60;
        long millis = timeInMilis % 1000;
        return String.format("%d:%02d:%03d", minutes, seconds, millis);

    }

    private static Comparator<Driver> getDriverComparator() {
        return Comparator.comparingLong(Driver::getBestTime);
    }
}
