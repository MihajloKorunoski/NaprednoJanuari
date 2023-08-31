package mk.ukim.finki.napredno.labs.complexnumbers;

class ComplexNumber<T extends Number, U extends Number> implements Comparable<ComplexNumber<T, U>> {

    private static final double EPSILON = 0.000001;

    private final T real;
    private final U imaginary;

    public ComplexNumber(T real, U imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public T getReal() {
        return real;
    }

    public U getImaginary() {
        return imaginary;
    }

    public double modul() {
        return Math.sqrt(Math.pow(getReal().doubleValue(), 2)
                + Math.pow(getImaginary().doubleValue(), 2));
    }

    @Override
    public int compareTo(ComplexNumber<T, U> o) {
        double m1 = this.modul();
        double m2 = o.modul();
        if (Math.abs(m1 - m2) < EPSILON)
            return 0;
        return m1 < m2 ? -1 : 1;
    }

    @Override
    public String toString() {
        if(getImaginary().doubleValue() < 0)
            return String.format("%.2f%.2fi", getReal().doubleValue(), getImaginary().doubleValue());
        return String.format("%.2f+%.2fi", getReal().doubleValue(), getImaginary().doubleValue());
    }
}
