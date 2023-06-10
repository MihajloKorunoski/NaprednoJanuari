package mk.ukim.finki.napredno.auditoriski.aud4.calculator;

public class Addition implements Strategy {
    @Override
    public double Operation(double a, double b) {
        return a + b;
    }
}
