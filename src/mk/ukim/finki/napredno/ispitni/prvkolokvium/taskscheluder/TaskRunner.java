package mk.ukim.finki.napredno.ispitni.prvkolokvium.taskscheluder;

import java.util.List;

class TaskRunner <T extends Task>{
    public void run(TaskScheduler<T> scheduler,T[]tasks){
        List<T> order=scheduler.schedule(tasks);
        order.forEach(System.out::println);
    }
}
