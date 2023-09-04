package mk.ukim.finki.napredno.exercises.prvkolokvium.genericevaluator;

interface IEvaluator<T> {
    boolean evaluate(T a, T b);
}
