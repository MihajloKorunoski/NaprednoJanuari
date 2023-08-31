package mk.ukim.finki.napredno.labs.scheduler;

import java.time.LocalDateTime;
import java.util.Objects;

class Timestamp<T> implements Comparable<Timestamp<? extends T>>{
    private LocalDateTime time;
    private T element;

    public Timestamp(LocalDateTime time, T element) {
        this.time = time;
        this.element = element;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public T getElement() {
        return element;
    }

    public boolean isBeforeNow(){
        return time.isBefore(LocalDateTime.now());
    }
    public boolean isAfterNow(){
        return time.isAfter(LocalDateTime.now());
    }
    @Override
    public int compareTo(Timestamp<? extends T> o) {
        return time.compareTo(o.time);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timestamp<?> timestamp = (Timestamp<?>) o;
        return Objects.equals(time, timestamp.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time);
    }

    @Override
    public String toString() {
        return String.format("%s %s", time, element);
    }
}
