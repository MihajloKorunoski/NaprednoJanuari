package mk.ukim.finki.napredno.kniga.integerarray;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayReader {
    public static IntegerArray readIntegerArray(InputStream in) {
        try(Scanner sc = new Scanner(in)){
            int n = sc.nextInt();
            int[] a = Arrays.stream(new int[n])
                    .map(i -> sc.nextInt())
                    .toArray();
            return new IntegerArray(a);
        }
    }
}
