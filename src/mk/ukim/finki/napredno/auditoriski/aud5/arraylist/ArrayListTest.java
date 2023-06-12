package mk.ukim.finki.napredno.auditoriski.aud5.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(100);
        List<String> stringList = new ArrayList<>();

        integerList.add(7);
        integerList.add(8);
        integerList.add(9);
        integerList.add(2);
        integerList.add(5);
        integerList.add(9);

        stringList.add("A");

        System.out.println(integerList);
        System.out.println(stringList);

        System.out.println(integerList.size());

        System.out.println(integerList.get(3));

        System.out.println(integerList.contains(9));
        System.out.println(integerList.contains(4));

        System.out.println(integerList.indexOf(9));
        System.out.println(integerList.lastIndexOf(9));

        System.out.println(integerList.removeIf(i -> i > 6));
        System.out.println(integerList);
    }
}
