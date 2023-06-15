package mk.ukim.finki.napredno.ispitni.prvkolokvium.numberprocessor;

import java.util.ArrayList;

public interface NumberProcessor<IN extends Number, R> {
    R compute(ArrayList<IN> numbers);
}
