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
        double[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Matrix.sum(a));
        System.out.println(Matrix.average(a));
    } //test
}