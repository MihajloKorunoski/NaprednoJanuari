package mk.ukim.finki.napredno.exercises.prvkolokvium.numberprocessor;

import java.util.ArrayList;

public class Numbers<N extends Number> {
    ArrayList<N> numbers;

    public Numbers(ArrayList<N> numbers) {
        this.numbers = numbers;
    }

    void process(NumberProcessor<N, ?> processor){
        System.out.println(processor.compute(numbers));
    }
}
