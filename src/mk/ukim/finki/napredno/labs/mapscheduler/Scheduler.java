package mk.ukim.finki.napredno.labs.mapscheduler;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

class Scheduler<T> {

    private TreeMap<Date,T> schedules;
    public Scheduler() {
        schedules = new TreeMap<>();
    }

    public void add(Date d, T t) {
        schedules.put(d,t);
    }

    public void remove(Date d) {
        schedules.remove(d);
    }

    public ArrayList<T> getAll(Date begin, Date end) {
        return new ArrayList<>(schedules.subMap(begin, end).values());
    }

    public T getFirst() {
        return schedules.pollFirstEntry().getValue();
    }

    public T next() {
        return schedules.ceilingEntry(new Date()).getValue();
    }

    public T getLast() {
        return schedules.pollLastEntry().getValue();
    }

    public T last() {
        return schedules.floorEntry(new Date()).getValue();
    }


}
