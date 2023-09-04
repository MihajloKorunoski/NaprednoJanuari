package mk.ukim.finki.napredno.exercises.prvkolokvium.numberprocessor;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumberProcessorTest {
    public static void main(String[] args) {

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        ArrayList<Double> doubleArrayList = new ArrayList<>();

        int countOfIntegers;
        Scanner sc = new Scanner(System.in);
        countOfIntegers = sc.nextInt();
        while (countOfIntegers > 0) {
            integerArrayList.add(sc.nextInt());
            --countOfIntegers;
        }

        int countOfDoubles;
        countOfDoubles = sc.nextInt();
        while (countOfDoubles > 0) {
            doubleArrayList.add(sc.nextDouble());
            --countOfDoubles;
        }

        Numbers<Integer> integerNumbers = new Numbers<>(integerArrayList);

        NumberProcessor<Integer, Long> firstProcessor = number -> number.stream()
                .filter(n -> n < 0)
                .count();
        System.out.println("RESULTS FROM THE FIRST NUMBER PROCESSOR");
        integerNumbers.process(firstProcessor);

        NumberProcessor<Integer, String> secondProcessor = numbers -> {
            DoubleSummaryStatistics summaryStatistics = numbers.stream()
                    .mapToDouble(i -> i)
                    .summaryStatistics();
            return String.format("Count: %d Min: %.2f Average: %.2f Max: %.2f",
                    summaryStatistics.getCount(),
                    summaryStatistics.getMin(),
                    summaryStatistics.getAverage(),
                    summaryStatistics.getMax());
        };
        System.out.println("RESULTS FROM THE SECOND NUMBER PROCESSOR");
        integerNumbers.process(secondProcessor);


        Numbers<Double> doubleNumbers = new Numbers<>(doubleArrayList);

        NumberProcessor<Double, List<Double>> thirdProcessor = numbers -> numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("RESULTS FROM THE THIRD NUMBER PROCESSOR");
        doubleNumbers.process(thirdProcessor);

        NumberProcessor<Double, Double> fourthProcessor = numbers -> {
            List<Double> sorted = thirdProcessor.compute(numbers);
            int size = sorted.size();
            return size % 2 == 0 ?
                    (sorted.get(size / 2 - 1) + sorted.get(size / 2)) / 2 :
                    sorted.get(size / 2);
        };

        System.out.println("RESULTS FROM THE FOURTH NUMBER PROCESSOR");
        doubleNumbers.process(fourthProcessor);
    }
}
