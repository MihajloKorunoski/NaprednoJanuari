package mk.ukim.finki.napredno.ispitni.prvkolokvium.taskscheluder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Schedulers {
    public static <T extends Task> TaskScheduler<T> getOrdered() {

        // vashiot kod ovde (annonimous class)
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

        // vashiot kod ovde (lambda expression)
        return tasks -> Arrays.stream(tasks)
                .filter(t -> t.getOrder() <= order)
                .collect(Collectors.toList());
    }
}
