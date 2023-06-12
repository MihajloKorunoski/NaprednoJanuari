package mk.ukim.finki.napredno.auditoriski.aud6.priorityqueue;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class GenericMathOperationsTest {

    public static String statistics(List<? extends Number> numbers) {

//        DoubleSummaryStatistics doubleSummaryStatistics = new DoubleSummaryStatistics();
//        numbers.forEach(i -> doubleSummaryStatistics.accept(i.doubleValue()));

        DoubleSummaryStatistics doubleSummaryStatistics = numbers.stream()
                .mapToDouble(Number::doubleValue)
                .summaryStatistics();

        double finalStandardDeviation = Math.sqrt(
                numbers.stream()
                        .mapToDouble(Number::doubleValue)
                        .map(d -> (d - doubleSummaryStatistics.getAverage()) * (d - doubleSummaryStatistics.getAverage()))
                        .average()
                        .orElse(0)
        );

        return String.format("""
                        Min: %.2f
                        Max: %.2f
                        Average: %.2f
                        Standard deviation: %.2f
                        Count: %d
                        Sum: %.2f""",
                doubleSummaryStatistics.getMin(),
                doubleSummaryStatistics.getMax(),
                doubleSummaryStatistics.getAverage(),
                finalStandardDeviation,
                doubleSummaryStatistics.getCount(),
                doubleSummaryStatistics.getSum());
    }

    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> integers = new ArrayList<>();
        IntStream.range(0, 100000)
                .forEach(i -> integers.add(random.nextInt(100) + 1));
        System.out.println(statistics(integers));

        List<Double> doubles = new ArrayList<>();
        IntStream.range(0, 100000)
                .forEach(i -> doubles.add(random.nextDouble() * 100.0));
        System.out.println(statistics(doubles));

    }
}
