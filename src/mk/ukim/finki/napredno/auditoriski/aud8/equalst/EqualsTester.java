package mk.ukim.finki.napredno.auditoriski.aud8.equalst;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class EqualsTester {
    public static <T> boolean equals(List<T> left, List<T> right) {
        Objects.requireNonNull(left, "left list must not be null");
        Objects.requireNonNull(right, "right list must not be null");


        return left.size() == right.size() && IntStream.range(0, left.size())
                .allMatch(i -> Objects.equals(left.get(i), right.get(i)));
    }

    public static void main(String[] args) {


        // Testing null list
        try {
            List<String> list1 = Arrays.asList("apple", "banana", "cherry");
            List<String> list2 = Arrays.asList("apple", "banana", "cherry");
            List<String> list3 = Arrays.asList("apple", "orange", "cherry");

            // Testing equal lists
            boolean result1 = equals(list1, list2);
            System.out.println("Lists list1 and list2 are equal: " + result1);

            // Testing unequal lists
            boolean result2 = equals(list1, list3);
            System.out.println("Lists list1 and list3 are equal: " + result2);

            List<String> list4 = null;
            boolean result3 = equals(list1, list4);
            System.out.println("Lists list1 and list4 are equal: " + result3);
        } catch (NullPointerException e) {
            System.out.println("Invalid List: " + e.getMessage());
            // Perform alternative actions or error handling
        }
    }
}
