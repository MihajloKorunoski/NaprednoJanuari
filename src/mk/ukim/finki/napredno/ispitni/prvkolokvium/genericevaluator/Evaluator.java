package mk.ukim.finki.napredno.ispitni.prvkolokvium.genericevaluator;

class Evaluator {

    static<T extends Comparable<T>> boolean evaluateExpression (T left, T right, String operator){
        IEvaluator<T> evaluator = EvaluatorBuilder.build(operator);
        return evaluator.evaluate(left,right);
    }
}
