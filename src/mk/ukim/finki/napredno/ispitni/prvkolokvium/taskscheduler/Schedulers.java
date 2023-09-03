package mk.ukim.finki.napredno.ispitni.prvkolokvium.taskscheduler;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Schedulers {
    public static <T extends Task> TaskScheduler<T> getOrdered() {
        return new TaskScheduler<T>() {
            @Override
            public List<T> schedule(T[] tasks) {
                return Arrays.stream(tasks)
                        .sorted(Comparator.comparingInt(Task::getOrder))
                        .collect(Collectors.toList());
            }
        };
    }

    public static <T extends Task> TaskScheduler<T> getFiltered(int order) {

        return tasks -> Arrays.stream(tasks)
                .filter(task -> task.getOrder() < order)
                .collect(Collectors.toList());

    }
}