package mk.ukim.finki.napredno.labs.groupofanagrams;

import java.io.InputStream;
import java.util.*;

public class Anagrams {

    public static void main(String[] args) {
        findAll(System.in);
    }

    public static void findAll(InputStream inputStream) {
        TreeMap<String, TreeSet<String>> anagramGroups = new TreeMap<>();
        List<String> keyOrder = new ArrayList<>();

        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNext()) {
            String word = scanner.next();

            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if(!anagramGroups.containsKey(sortedWord)){
                keyOrder.add(sortedWord);
            }
            anagramGroups.computeIfAbsent(sortedWord, k -> new TreeSet<>())
                    .add(word);
        }
        scanner.close();

        for(String key : keyOrder){
            TreeSet<String> group = anagramGroups.get(key);

            if(group.size() >= 5){
                String joinedAnagrams = String.join(" ", group);
                System.out.println(joinedAnagrams);
            }
        }
    }
}

