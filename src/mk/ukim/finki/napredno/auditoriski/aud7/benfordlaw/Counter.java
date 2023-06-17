package mk.ukim.finki.napredno.auditoriski.aud7.benfordlaw;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Counter {
    private int[] countingArray;
    private int digitsCount;

    public Counter() {
        countingArray = new int[10];
        digitsCount = 0;
    }

    public void countDigit(int digit) {
        countingArray[digit]++;
        digitsCount++;
    }

    private double getPercentage(int digit) {
        return countingArray[digit] * 100.0 / digitsCount;
    }

    @Override
    public String toString() {
        return IntStream.range(1, 10)
                .mapToObj(i -> String.format("%d --> %.2f%%", i, getPercentage(i)))
                .collect(Collectors.joining("\n"));
    }
}
