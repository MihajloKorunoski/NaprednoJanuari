package mk.ukim.finki.napredno.ispitni.prvkolokvium.taskscheluder;

import java.util.List;

interface TaskScheduler <T extends Task> {
    public List<T> schedule(T [] tasks);
}
