package mk.ukim.finki.napredno.exercises.prvkolokvium.weightcontainer;

public interface Weightable extends Comparable<Weightable> {
    double getWeight();

    @Override
    default int compareTo(Weightable o){
        return Double.compare(getWeight(), o.getWeight());
    }
}
