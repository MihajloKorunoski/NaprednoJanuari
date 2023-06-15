package mk.ukim.finki.napredno.ispitni.prvkolokvium.generickievaluator;

public class Evaluator {
    public static <T extends Comparable<T>> boolean evaluateExpression(T left, T right, String operator) {
        IEvaluator<T> evaluator = EvaluatorBuilder.build(operator);
        return evaluator.evaluate(left, right);
    }
}
