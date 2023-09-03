package mk.ukim.finki.napredno.ispitni.prvkolokvium.genericevaluator;

class EvaluatorBuilder {
    public static <T extends Comparable<T>> IEvaluator<T> build (String operator){
        switch (operator){
            case ">":
                return (a, b) -> a.compareTo(b) > 0;
            case "==":
                return (a, b) -> a.compareTo(b) == 0;
            case "!=":
                return (a, b) -> a.compareTo(b) != 0;
            case "<":
                return (a, b) -> a.compareTo(b) < 0;
            default:
                throw new IllegalArgumentException("Unsupported operator: "+ operator);
        }
    }
}
