package mk.ukim.finki.napredno.ispitni.prvkolokvium.f1race;

import java.util.List;

class Driver {
    private String name;
    private List<Long> times;

    public Driver(String name, List<Long> times) {
        this.name = name;
        this.times = times;
    }

    public String getName() {
        return name;
    }

    public long getBestTime(){
        return times.stream()
                .min(Long::compare)
                .orElse(Long.MAX_VALUE);
    }
}
