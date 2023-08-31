package mk.ukim.finki.napredno.labs.superstring;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.stream.Collectors;

class SuperString {

    private LinkedList<String> list;
    private Deque<Integer> undoStack;

    public SuperString() {
        list = new LinkedList<>();
        undoStack = new LinkedList<>();
    }

    public void append(String next) {
        list.addLast(next);
        undoStack.push(1);
    }

    public void insert(String next) {
        list.addFirst(next);
        undoStack.push(-1);

    }

    @Override
    public String toString() {
        return String.join("", list);
    }

    public boolean contains(String next) {
        return toString().contains(next);
    }

//    public void reverse() {
//        list = list.stream()
//                .map(s -> new StringBuilder(s).reverse().toString())
//                .collect(Collectors.toCollection(LinkedList::new));
//        Collections.reverse(list);
//        undoStack = undoStack.stream().map(i -> i * (-1)).collect(Collectors.toCollection(LinkedList::new));
//    }

    public void reverse() {
        ListIterator<String> it = list.listIterator();
        while (it.hasNext())
            it.set(new StringBuilder(it.next()).reverse().toString());
        Collections.reverse(list);
        undoStack = undoStack.stream().map(i -> i * (-1)).collect(Collectors.toCollection(LinkedList::new));
    }



    public void removeLast(int k) {
        while (k-- > 0 && !undoStack.isEmpty()) {
            if (undoStack.pop() < 0)
                list.removeFirst();
            else
                list.removeLast();
        }
    }
}
