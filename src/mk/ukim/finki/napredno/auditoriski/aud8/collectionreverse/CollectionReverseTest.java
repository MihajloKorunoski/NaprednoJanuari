package mk.ukim.finki.napredno.auditoriski.aud8.collectionreverse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionReverseTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("A", "B", "C", "D"));

        reverseCollection(list);

        System.out.println(list);
    }

    private static void reverseCollection(List<String> list) {
        Collections.reverse(list);
    }
}
