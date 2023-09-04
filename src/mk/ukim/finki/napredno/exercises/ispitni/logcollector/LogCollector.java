package mk.ukim.finki.napredno.exercises.ispitni.logcollector;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class LogCollector {
    Map<String, Service> services;

    public LogCollector() {
        services = new HashMap<>();
    }

    void addLog(String logString) {
        Log log = Log.createLog(logString);
        services.computeIfAbsent(log.getServiceName(),k -> new Service(log.getServiceName())).addLog(log);
    }


    void printServicesBySeverity() {
        services.values().stream()
                .sorted(Comparator.comparing(Service::averageSeverityForAllLogs).reversed())
                .forEach(System.out::println);
    }


    void displayLogs(String service, String microservice, String order) {
        services.get(service).displayLogs(microservice,order);
    }

    public Map<Integer, Integer> getSeverityDistribution(String service, String microservice) {
        return services.get(service).getSeverityDistribution(microservice);
    }
}
