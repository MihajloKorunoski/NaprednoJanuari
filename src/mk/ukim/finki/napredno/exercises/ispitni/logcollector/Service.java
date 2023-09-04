package mk.ukim.finki.napredno.exercises.ispitni.logcollector;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Service {
    String name;
    private Map<String, MicroService> microservices = new HashMap<>();

    public Service(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        IntSummaryStatistics severityStatistics = microservices.values()
                .stream()
                .flatMap(microservice -> microservice.logs.stream())
                .mapToInt(Log::severity)
                .summaryStatistics();

        return String.format("Service name: %s"
                        + " Count of microservices: %d"
                        + " Total logs in service: %d"
                        + " Average severity for all logs: %.2f"
                        + " Average number of logs per microservice: %.2f",
                getName(),
                microservices.size(),
                severityStatistics.getCount(),
                severityStatistics.getAverage(),
                (float) severityStatistics.getCount() / microservices.size()
        );
    }

    public double averageSeverityForAllLogs() {
        return microservices.values().stream()
                .flatMap(microService -> microService.logs.stream())
                .mapToInt(Log::severity)
                .average()
                .orElse(0.0);
    }

    public void addLog(Log log) {
        microservices.computeIfAbsent(log.getMicroserviceName(),
                k -> new MicroService(log.getMicroserviceName())).addLog(log);
    }

    public Map<Integer, Integer> getSeverityDistribution(String microservice) {
        Stream<Log> logStream = getLogStream(microservice);

        return logStream.collect(Collectors.groupingBy(Log::severity, TreeMap::new, Collectors.summingInt(i -> 1)));
    }

    private Stream<Log> getLogStream(String microservice) {
        Stream<Log> logStream = (microservice == null) ?
                microservices.values().stream().flatMap(s -> s.logs.stream()) :
                microservices.get(microservice).logs.stream();
        return logStream;
    }

    void displayLogs(String microservice, String order) {
        Comparator<Log> byTimestamp = Comparator.comparing(Log::getTimestamp);
        Comparator<Log> bySeverity = Comparator.comparing(Log::severity).thenComparing(Log::getTimestamp);

        Comparator<Log> logComparator;
        switch (order) {
            case "NEWEST_FIRST":
                logComparator = byTimestamp.reversed();
                break;
            case "OLDEST_FIRST":
                logComparator = byTimestamp;
                break;
            case "MOST_SEVERE_FIRST":
                logComparator = bySeverity.reversed();
                break;
            default:
                logComparator = bySeverity;
        }
        Stream<Log> logStream = getLogStream(microservice);

        logStream.sorted(logComparator).forEach(System.out::println);
    }
}
