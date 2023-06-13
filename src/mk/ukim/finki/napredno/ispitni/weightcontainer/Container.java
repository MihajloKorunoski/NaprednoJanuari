package mk.ukim.finki.napredno.ispitni.weightcontainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Container<T extends Weightable> {
    private List<T> elements;

    public Container() {
        elements = new ArrayList<>();
    }

    public void addElement(T element) {
        elements.add(element);
    }

    public List<T> lighterThan(T element) {
        return elements.stream()
                .filter(i -> i.compareTo(element) < 0)
                .collect(Collectors.toList());
    }

    public List<T> between(T wa, T wb) {
        return elements.stream()
                .filter(i -> i.compareTo(wa) > 0 && i.compareTo(wb) < 0)
                .collect(Collectors.toList());
    }

    double containerSum() {
        return elements.stream()
                .mapToDouble(Weightable::getWeight)
                .sum();
    }

    public double compare(Container<? extends Weightable> container2) {
        return Double.compare(containerSum(), container2.containerSum());
    }
}
