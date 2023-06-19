package mk.ukim.finki.napredno.auditoriski.aud8.eratosthenes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EratosthenesTest {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.range(2, 1000)
                .boxed()
                .collect(Collectors.toList());

        Eratosthenes eratosthenes = new Eratosthenes();
        eratosthenes.process(numbers);

        System.out.println(numbers);
    }

}
