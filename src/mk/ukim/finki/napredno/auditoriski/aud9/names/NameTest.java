package mk.ukim.finki.napredno.auditoriski.aud9.names;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class NameTest {
    private static Map<String, Integer> readNames(InputStream is) {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        return br.lines()
                .map(line -> line.split("\\s+"))
                .collect(Collectors.toMap(parts -> parts[0], parts -> Integer.parseInt(parts[1])));
    }

    public static void main(String[] args) {
        try {
            Map<String, Integer> boyNames = readNames(new FileInputStream("C:\\Users\\mihaj\\OneDrive\\Desktop\\Projects" +
                    "\\NaprednoJanuari\\src\\mk\\ukim\\finki\\napredno\\auditoriski\\aud9\\names\\boynames.txt"));
            Map<String, Integer> girlNames = readNames(new FileInputStream("C:\\Users\\mihaj\\OneDrive\\Desktop\\Projects" +
                    "\\NaprednoJanuari\\src\\mk\\ukim\\finki\\napredno\\auditoriski\\aud9\\names\\girlnames.txt"));

            Set<String> uniqueNames = new HashSet<>(boyNames.keySet());
            uniqueNames.retainAll(girlNames.keySet());

            TreeMap<String, Integer> unisexNamesMap = new TreeMap<>(Comparator.reverseOrder());
            uniqueNames.forEach(name -> unisexNamesMap.put(name, boyNames.get(name) + girlNames.get(name)));

            unisexNamesMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(entry -> System.out.printf("%s -> %d\n", entry.getKey(), entry.getValue()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}
