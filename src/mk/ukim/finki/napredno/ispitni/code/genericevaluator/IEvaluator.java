package mk.ukim.finki.napredno.ispitni.code.genericevaluator;

interface IEvaluator<T> {
    boolean evaluate(T a, T b);
}
