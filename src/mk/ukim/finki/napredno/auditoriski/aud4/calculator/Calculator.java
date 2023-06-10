package mk.ukim.finki.napredno.auditoriski.aud4.calculator;

public class Calculator {
    private double result;
    private Strategy strategy;

    public Calculator() {
        result = 0.0;
    }

    public String execute(char operation, double value) throws UnknownOperatorExecption {
        if (operation == '+') {
            strategy = new Addition();
        } else if (operation == '-') {
            strategy = new Subtraction();
        } else if (operation == '*') {
            strategy = new Multiplication();
        } else if (operation == '/') {
            strategy = new Division();
        } else throw new UnknownOperatorExecption(operation);

        result = strategy.Operation(result, value);
        return String.format("result %c %.2f = %.2f", operation, value, result);
    }

    public double getResult() {
        return result;
    }

    public String init(){
        return String.format("result = %.2f",result);
    }

    @Override
    public String toString() {
        return String.format("Updated result = %.2f",result);
    }
}
