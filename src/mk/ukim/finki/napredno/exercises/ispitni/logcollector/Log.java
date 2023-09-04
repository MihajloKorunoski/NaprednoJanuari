package mk.ukim.finki.napredno.exercises.ispitni.logcollector;

import java.util.Arrays;
import java.util.stream.Collectors;

abstract class Log {
    String serviceName;
    String microserviceName;
    String type;


    String message;
    long timestamp;

    public Log(String serviceName, String microserviceName, String type, String message, long timestamp) {
        this.serviceName = serviceName;
        this.microserviceName = microserviceName;
        this.type = type;
        this.message = message;
        this.timestamp = timestamp;
    }

    public static Log createLog(String log) {
        String[] parts = log.split("\\s+");
        String serviceName = parts[0];
        String microserviceName = parts[1];
        String type = parts[2];
        String message = Arrays.stream(parts)
                .skip(3)
                .limit(parts.length - 1)
                .collect(Collectors.joining(" "));
        long timestamp = Long.parseLong(parts[parts.length - 1]);
        if (type.equalsIgnoreCase("info")) {
            return new InfoLog(serviceName, microserviceName, type, message, timestamp);
        } else if (type.equalsIgnoreCase("warn")) {
            return new WarnLog(serviceName, microserviceName, type, message, timestamp);
        } else {
            return new ErrorLog(serviceName, microserviceName, type, message, timestamp);
        }

    }

    abstract int severity();

    public String getServiceName() {
        return serviceName;
    }

    public String getMicroserviceName() {
        return microserviceName;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("%s|%s [%s] %s T:%d", getServiceName(),
                getMicroserviceName(),
                getType(),
                getMessage(),
                getTimestamp());

    }
}
