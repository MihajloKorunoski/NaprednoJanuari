package mk.ukim.finki.napredno.ispitni.prvkolokvium.generickievaluator;

public class EvaluatorBuilder {
    static <T extends Comparable<T>> IEvaluator<T> build(String operator) {
        return switch (operator) {
            case ">" -> (left, right) -> left.compareTo(right) > 0;
            case "==" -> (left, right) -> left.compareTo(right) == 0;
            case "<" -> (left, right) -> left.compareTo(right) < 0;
            default -> (left, right) -> left.compareTo(right) != 0;
        };
    }
}
