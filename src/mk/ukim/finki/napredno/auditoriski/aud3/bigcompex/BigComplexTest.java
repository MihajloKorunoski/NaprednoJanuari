package mk.ukim.finki.napredno.auditoriski.aud3.bigcompex;

import java.math.BigDecimal;
import java.util.Scanner;

public class BigComplexTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal real1 = new BigDecimal("2.5");
        BigDecimal imag1 = new BigDecimal("3.7");
        BigComplex number1 = new BigComplex(real1, imag1);
        System.out.println("Number 1: " + number1);

        BigDecimal real2 = new BigDecimal("1.8");
        BigDecimal imag2 = new BigDecimal("4.2");
        BigComplex number2 = new BigComplex(real2, imag2);
        System.out.println("Number 2: " + number2);

        System.out.println("Choose the operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        int operation = scanner.nextInt();

        BigComplex result;
        switch (operation) {
            case 1 -> {
                result = BigComplex.add(number1, number2);
                System.out.println("Addition: " + result);
            }
            case 2 -> {
                result = BigComplex.subtract(number1, number2);
                System.out.println("Subtraction: " + result);
            }
            case 3 -> {
                result = BigComplex.multiply(number1, number2);
                System.out.println("Multiplication: " + result);
            }
            case 4 -> {
                result = BigComplex.divide(number1, number2);
                System.out.println("Division: " + result);
            }
            default -> System.out.println("Invalid operation.");
        }
    }
}

