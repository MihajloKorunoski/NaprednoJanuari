package mk.ukim.finki.napredno.auditoriski.aud5.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FunctionalInterfacesTest {
    public static void main(String[] args) {
        Predicate<Integer> lessThan100 = number -> number < 100;
        Supplier<Integer> integerSupplier = () -> new Random().nextInt(1000);

        Consumer<String> stringConsumer = s -> System.out.println(s);

        Consumer<String> stringConsumer2 = System.out::println;


        Function<Integer, String> getAddFiveToNumberAndFormat = integer -> String.format("%d is the number", integer + 5);

        BiFunction<Integer,Integer,String> sumNumbersAndFormat = ((integer, integer2) -> String.format("%d + %d = %d", integer, integer2, integer + integer2));

        List<String> list = new ArrayList<>();
        list.add("S");
        list.add("A");
        list.add ("T");
        list.add ("N");
        list.add ("I");
        list.add ("J");
        list.add ("A");
        list.stream().forEach(stringConsumer);
        list.forEach(stringConsumer);

    }


}
