package mk.ukim.finki.napredno.auditoriski.aud3.bigcompex;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigComplex {
    private final BigDecimal realPart;
    private final BigDecimal imaginaryPart;

    public BigComplex(BigDecimal realPart, BigDecimal imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public static BigComplex add(BigComplex number1, BigComplex number2) {
        return new BigComplex(number1.realPart.add(number2.realPart),
                number1.imaginaryPart.add(number2.imaginaryPart));
    }

    public static BigComplex subtract(BigComplex number1, BigComplex number2) {
        return new BigComplex(number1.realPart.subtract(number2.realPart),
                number1.imaginaryPart.subtract(number2.imaginaryPart));
    }

    public static BigComplex multiply(BigComplex number1, BigComplex number2) {
        BigDecimal realPart = number1.realPart.multiply(number2.realPart).subtract(number1.imaginaryPart.multiply(number2.imaginaryPart));
        BigDecimal imaginaryPart = number1.realPart.multiply(number2.imaginaryPart).add(number1.imaginaryPart.multiply(number2.realPart));
        return new BigComplex(realPart, imaginaryPart);
    }

    public static BigComplex divide(BigComplex number1, BigComplex number2) {
        BigDecimal denominator = number2.realPart.pow(2).add(number2.imaginaryPart.pow(2));
        BigDecimal realPart = number1.realPart.multiply(number2.realPart).add(number1.imaginaryPart.multiply(number2.imaginaryPart)).divide(denominator, RoundingMode.HALF_UP);
        BigDecimal imaginaryPart = number1.imaginaryPart.multiply(number2.realPart).subtract(number1.realPart.multiply(number2.imaginaryPart)).divide(denominator, RoundingMode.HALF_UP);
        return new BigComplex(realPart, imaginaryPart);
    }

    @Override
    public String toString() {
        return "BigComplex{" +
                "realPart=" + realPart +
                ", imaginaryPart=" + imaginaryPart +
                '}';
    }
}
