package mk.ukim.finki.napredno.exercises.ispitni.logcollector;

class InfoLog extends Log{
    public InfoLog(String serviceName, String microserviceName, String type, String message, long timestamp) {
        super(serviceName, microserviceName, type, message, timestamp);
    }

    @Override
    int severity() {
        return 0;
    }
}
