package mk.ukim.finki.napredno.auditoriski.aud8.countoccurences;

import java.util.Arrays;
import java.util.Collection;

public class CountOccurrencesTest {

    public static int count(Collection<Collection<String>> collections, String str) {
        int counter = 0;

        for (Collection<String> collection : collections) {
            for (String element : collection) {
                if (element.equals(str))
                    ++counter;
            }
        }
        return counter;
    }

    public static int count2(Collection<Collection<String>> collections, String str) {
        return Math.toIntExact(collections.stream()
                .flatMap(Collection::stream)
                .filter(str::equals)
                .count());
    }

    public static void main(String[] args) {
        // Sample collections
        Collection<String> collection1 = Arrays.asList("apple", "banana", "apple");
        Collection<String> collection2 = Arrays.asList("orange", "orange");
        Collection<String> collection3 = Arrays.asList("kiwi", "grape", "kiwi", "kiwi");
        Collection<Collection<String>> collections = Arrays.asList(collection1, collection2, collection3);

        String searchStr = "apple";

        // Testing the count method
        int count1 = count(collections, searchStr);
        System.out.println("Count using count method: " + count1);

        // Testing the count2 method
        int count2 = count2(collections, searchStr);
        System.out.println("Count using count2 method: " + count2);
    }

}
