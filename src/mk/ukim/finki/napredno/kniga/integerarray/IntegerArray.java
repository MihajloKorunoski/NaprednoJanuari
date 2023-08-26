package mk.ukim.finki.napredno.kniga.integerarray;


import java.util.Arrays;
import java.util.stream.IntStream;

public class IntegerArray {

    private final int[] a;

    public IntegerArray(int[] ints) {
        a = Arrays.copyOf(ints, ints.length);
    }

    public IntegerArray(int[] ints, boolean to_copy) {
        if (to_copy) {
            a = Arrays.copyOf(ints, ints.length);
        } else
            a = ints;
    }

    public IntegerArray getSorted() {
        int[] sorted = Arrays.stream(a)
                .sorted()
                .toArray();
        return new IntegerArray(sorted);
    }

    public int sum() {
        return Arrays.stream(a).sum();
    }

    public double average() {
        return sum() * 1.0 / a.length;
    }

    public int length() {
        return a.length;
    }

    public int getElementAt(int i) {
        return a[i];
    }

    public IntegerArray concat(IntegerArray array2) {
        int[] res = IntStream.concat(Arrays.stream(a), Arrays.stream(array2.a))
                .toArray();
        return new IntegerArray(res, true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerArray that = (IntegerArray) o;
        return Arrays.equals(a, that.a);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(a);
    }

    @Override
    public String toString() {
        return Arrays.toString(a);
    }
}
