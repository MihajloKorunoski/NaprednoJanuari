package mk.ukim.finki.napredno.auditoriski.aud8.eratosthenes;

import java.util.List;
import java.util.stream.IntStream;

class Eratosthenes {

    private boolean isPrime(int number) {
        return IntStream.range(2, (int) Math.sqrt(number) + 1)
                .noneMatch(i -> number % i == 0);
    }

    public void process(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (isPrime((numbers.get(i)))) {
                for (int j = i + 1; j < numbers.size(); j++) {
                    if (numbers.get(j) % numbers.get(i) == 0){
                        numbers.remove(j);
                        j--;
                    }
                }
            }
        }
    }
}
