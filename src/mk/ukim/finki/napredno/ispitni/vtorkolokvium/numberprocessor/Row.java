package mk.ukim.finki.napredno.ispitni.vtorkolokvium.numberprocessor;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Row {
    List<Integer> numbers;

    public Row(String line) {
        numbers = Arrays.stream(line.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public boolean condition() {
        int max = max();

        long frequencyOfMaxNumber = numbers.stream()
                .filter(num -> num == max)
                .count();

        long maxFrequency = numbers.stream()
                .mapToLong(numb -> Collections.frequency(numbers, numb))
                .max()
                .orElse(0);

        return frequencyOfMaxNumber == maxFrequency;
    }

    public int max() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

}
