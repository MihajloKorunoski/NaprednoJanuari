package mk.ukim.finki.napredno.auditoriski.aud6.box;

import java.util.stream.IntStream;

public class BoxTest {

    public static void main(String[] args) {
        Box<Circle> box = new Box<>();

        IntStream.range(0,100)
                .forEach(i -> box.add(new Circle()));

        IntStream.range(0, 103)
                .forEach(i -> System.out.println(box.draw()));
    }
}
