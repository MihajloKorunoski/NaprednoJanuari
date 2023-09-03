package mk.ukim.finki.napredno.ispitni.prvkolokvium.minmax;

class MinMax<T extends Comparable<T>> {
    private T min;
    private T max;
    private int total;
    private int minCount;
    private int maxCount;

    public MinMax() {
        total = 0;
        minCount = 0;
        maxCount = 0;
    }

    void update(T element) {
        if (total == 0) {
            min = element;
            max = element;
        }
        ++total;
        if (element.compareTo(min) < 0) {
            minCount = 1;
            min = element;
        } else {
            if (element.compareTo(min) == 0) {
                minCount++;
            }
        }
        if (element.compareTo(max) > 0) {
            maxCount = 1;
            max = element;
        } else {
            if (element.compareTo(max) == 0) {
                maxCount++;
            }
        }
    }

    T max() {
        return max;
    }

    T min() {
        return min;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d\n", min(), max(), total - (maxCount + minCount));
    }
}
