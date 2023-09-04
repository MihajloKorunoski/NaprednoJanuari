package mk.ukim.finki.napredno.exercises.ispitni.logcollector;

import java.util.ArrayList;
import java.util.List;

class MicroService {
    String name;
    List<Log> logs = new ArrayList<>();

    public MicroService(String name) {
        this.name = name;
    }

    public void addLog(Log log) {
        logs.add(log);
    }
}
