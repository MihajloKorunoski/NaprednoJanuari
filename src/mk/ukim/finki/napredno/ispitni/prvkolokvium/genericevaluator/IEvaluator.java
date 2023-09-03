package mk.ukim.finki.napredno.ispitni.prvkolokvium.genericevaluator;

interface IEvaluator<T> {
    boolean evaluate(T a, T b);
}
