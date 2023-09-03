package mk.ukim.finki.napredno.ispitni.code.taskscheduler;

import java.util.List;

interface TaskScheduler<T extends Task> {
    List<T> schedule(T[] tasks);
}
