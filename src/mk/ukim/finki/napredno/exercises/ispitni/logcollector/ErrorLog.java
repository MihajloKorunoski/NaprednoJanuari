package mk.ukim.finki.napredno.exercises.ispitni.logcollector;

class ErrorLog extends Log {
    public ErrorLog(String serviceName, String microserviceName, String type, String message, long timestamp) {
        super(serviceName, microserviceName, type, message, timestamp);
    }

    @Override
    int severity() {
        int severity = 3;
        if (message.toLowerCase().contains("fatal"))
            severity += 2;
        if (message.toLowerCase().contains("exception"))
            severity += 3;
        return severity;
    }
}
