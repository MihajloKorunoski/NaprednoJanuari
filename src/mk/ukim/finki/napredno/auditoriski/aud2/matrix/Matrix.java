package mk.ukim.finki.napredno.auditoriski.aud2.matrix;

import java.util.Arrays;


public class Matrix
{
    public static double sum(double[][] a){
        return Arrays.stream(a).flatMapToDouble(Arrays::stream).sum();
    }
    public static double average(double[][] a){
        return sum(a)/(a.length * a[0].length);
    }

    public static void main(String[] args)
    {
        double[][] matrix1 = {
                {1.5, 2.3, 3.1},
                {4.2, 5.7, 6.9},
                {7.4, 8.1, 9.6}
        };

        double sum1 = sum(matrix1);
        double average1 = average(matrix1);

        System.out.println("Matrix 1:");
        System.out.println("Sum: " + sum1);
        System.out.println("Average: " + average1);

        double[][] matrix2 = {
                {2.5, 3.7},
                {5.1, 6.3},
                {8.9, 9.2}
        };

        double sum2 = sum(matrix2);
        double average2 = average(matrix2);

        System.out.println("\nMatrix 2:");
        System.out.println("Sum: " + sum2);
        System.out.println("Average: " + average2);
    }
}