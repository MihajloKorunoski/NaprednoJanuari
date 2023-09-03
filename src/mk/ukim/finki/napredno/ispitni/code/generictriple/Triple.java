package mk.ukim.finki.napredno.ispitni.code.generictriple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Triple<T extends Number> {

    public List<T> list;

    public Triple(T a, T b, T c) {
        list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
    }

    public double max() {
        return Collections.max(list, Comparator.comparingDouble(Number::doubleValue)).doubleValue();
    }

    public double average() {
        return list.stream().mapToDouble(Number::doubleValue).average().orElse(0);

    }

    public void sort() {
        list.sort(Comparator.comparing(Number::doubleValue));
    }

    @Override
    public String toString() {
        return String.format("%.2f %.2f %.2f", list.get(0).doubleValue(),
                list.get(1).doubleValue(),
                list.get(2).doubleValue());
    }
}
