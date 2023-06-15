package mk.ukim.finki.napredno.ispitni.prvkolokvium.generickievaluator;

public interface IEvaluator<T extends Comparable<T>> {
    boolean evaluate (T a, T b);
}
