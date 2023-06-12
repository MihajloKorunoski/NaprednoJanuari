package mk.ukim.finki.napredno.auditoriski.aud6.priorityqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PriorityQueue<T> {

    private List<PriorityQueueElement<T>> elements;

    public PriorityQueue() {
        elements = new ArrayList<>();
    }

    public void add(T item, int priority) {
        PriorityQueueElement<T> newElement = new PriorityQueueElement<>(item, priority);

        int i = IntStream.range(0, elements.size())
                .filter(index -> newElement.compareTo(elements.get(index)) <= 0)
                .findFirst()
                .orElse(elements.size());

        elements.add(i, newElement);
    }

    public T remove(){
        if(elements.size()==0)
            return null;
        return elements.remove(elements.size()-1).getElement();
    }
}
