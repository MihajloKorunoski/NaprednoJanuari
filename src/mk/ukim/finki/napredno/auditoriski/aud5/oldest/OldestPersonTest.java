package mk.ukim.finki.napredno.auditoriski.aud5.oldest;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OldestPersonTest {
    public static List<Person> readData(InputStream inputStream){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        return bufferedReader.lines()
                .map(Person::new)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\mihaj\\OneDrive\\Desktop\\Projects\\" +
                "NaprednoJanuari\\src\\mk\\ukim\\finki\\napredno\\auditoriski\\aud5" +
                "\\files\\people");

        try {
            List<Person> list = readData(new FileInputStream(file));

            if(list.stream()
                    .max(Comparator.naturalOrder())
                    .isPresent())
                System.out.println(list.stream()
                        .max(Comparator.naturalOrder())
                        .get());

            list.stream()
                    .max(Comparator.naturalOrder())
                    .ifPresent(System.out::println);

            Collections.sort(list);
            System.out.println(list.get(list.size() - 1));

            System.out.println(Collections.max(list));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
