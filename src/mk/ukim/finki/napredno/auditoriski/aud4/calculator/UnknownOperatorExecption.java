package mk.ukim.finki.napredno.auditoriski.aud4.calculator;

public class UnknownOperatorExecption extends Throwable {
    public UnknownOperatorExecption(char operation) {
        super(String.format("This operator %c is not valid.", operation));
    }
}
