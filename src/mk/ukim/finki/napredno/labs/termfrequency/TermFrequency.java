package mk.ukim.finki.napredno.labs.termfrequency;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

class TermFrequency {
    private Map<String, Integer> frequency;
    private Set<String> stopWords;


    public TermFrequency(InputStream in, String[] stopWords) {
        this.frequency = new TreeMap<>();
        this.stopWords = new HashSet<>(Arrays.asList(stopWords));
        processText(in);
    }

    private void processText(InputStream in) {
        Scanner sc = new Scanner(in);
        while (sc.hasNext()) {
            String word = cleanWord(sc.next());
            if (!word.isEmpty() && !stopWords.contains(word))
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
    }

    private String cleanWord(String next) {
        return next.toLowerCase()
                .replaceAll("[,.?;:]", "");
    }

    public int countTotal() {
        return frequency.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int countDistinct() {
        return frequency.size();
    }

    public List<String> mostOften(int i) {
        return frequency.entrySet()
                .stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(i)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
