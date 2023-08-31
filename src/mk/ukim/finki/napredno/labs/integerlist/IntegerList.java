package mk.ukim.finki.napredno.labs.integerlist;


import java.util.*;

class IntegerList {
    private LinkedList<Integer> integerList;

    public IntegerList() {
        integerList = new LinkedList<>();
    }

    public IntegerList(Integer... numbers) {
        this();
        integerList.addAll(Arrays.asList(numbers));
    }

    public void add(int el, int idx) {
        while (idx > integerList.size())
            integerList.add(0);
        integerList.add(idx, el);
    }

    public void set(int el, int idx) {
        integerList.set(el, idx);
    }

    public int remove(int idx) {
        return integerList.remove(idx);
    }

    public int count(int el) {
        return Collections.frequency(integerList, el);
    }

    public void removeDuplicates() {
        Set<Integer> seen = new HashSet<>();
        Iterator<Integer> it = integerList.descendingIterator();
        while (it.hasNext()) {
            int current = it.next();
            if (seen.contains(current))
                it.remove();
            else
                seen.add(current);
        }
    }

    public IntegerList addValue(int value) {
        Integer[] updatedValues = integerList.stream()
                .map(i -> i + value)
                .toArray(Integer[]::new);
        return new IntegerList(updatedValues);
    }

    public void shift(int idx, int k) {
        if (integerList.isEmpty())
            return;
        int newPosition = (idx + k) % integerList.size();

        if (newPosition < 0)
            newPosition += integerList.size();

        Integer element = integerList.remove(idx);
        integerList.add(newPosition, element);
    }

    public void shiftLeft(int idx, int k) {
        shift(idx, -k);

    }

    public void shiftRight(int idx, int k) {
        shift(idx, k);
    }

    public int sumFirst(int k) {
        return integerList.stream()
                .limit(k)
                .mapToInt(Integer::intValue)
                .sum();

    }

    public int sumLast(int k) {
        return integerList.stream()
                .skip(Math.max(0, integerList.size() - k))
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int size() {
        return integerList.size();
    }

    public int get(int idx) {
        return integerList.get(idx);
    }
}
