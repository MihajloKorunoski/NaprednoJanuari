package mk.ukim.finki.napredno.labs.resizablearray;

class IntegerArray extends ResizableArray<Integer> {
    public double sum() {
        return getList().stream()
                .mapToDouble(Integer::intValue)
                .sum();
    }

    public double mean() {
        return sum() / count();
    }

    public int countNonZero() {
        return (int) getList().stream()
                .filter(i -> i != 0)
                .count();
    }

    public IntegerArray distinct() {
        IntegerArray res = new IntegerArray();
        getList().stream().distinct().forEach(res::addElement);
        return res;
    }

    public IntegerArray increment(int i) {
        IntegerArray res = new IntegerArray();
        getList().stream().map(element -> element + i).forEach(res::addElement);
        return res;
    }
}
