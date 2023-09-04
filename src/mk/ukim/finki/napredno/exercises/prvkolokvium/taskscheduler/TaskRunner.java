package mk.ukim.finki.napredno.exercises.prvkolokvium.taskscheduler;

import java.util.List;

class TaskRunner<T extends Task> {
    public void run(TaskScheduler<T> scheduler, T[] tasks) {
        List<T> order = scheduler.schedule(tasks);
        order.forEach(System.out::println);
    }
}
