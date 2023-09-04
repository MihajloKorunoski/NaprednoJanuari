package mk.ukim.finki.napredno.exercises.ispitni.logcollector;

class WarnLog extends Log {
    public WarnLog(String serviceName, String microserviceName, String type, String message, long timestamp) {
        super(serviceName, microserviceName, type, message, timestamp);
    }

    @Override
    int severity() {
        return message.toLowerCase().contains("might cause error") ? 2 : 1;
    }
}
