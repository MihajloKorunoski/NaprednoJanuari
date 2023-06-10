package mk.ukim.finki.napredno.auditoriski.aud4.calculator;

public class Division implements Strategy {
    @Override
    public double Operation(double a, double b) {
        if(b==0)
            throw new ArithmeticException("Division by zero not possible");
        return a/b;
    }
}
