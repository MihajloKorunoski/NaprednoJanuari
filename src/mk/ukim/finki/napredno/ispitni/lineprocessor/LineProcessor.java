package mk.ukim.finki.napredno.ispitni.lineprocessor;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LineProcessor {

    List<String> lines;

    public LineProcessor() {
        lines = new ArrayList<>();
    }

    private int countOccurrences(String line, char c) {
        char target = Character.toLowerCase(c);
        return (int) line.chars()
                .map(Character::toLowerCase)
                .filter(i ->  i == target)
                .count();
    }

    public void readLines(InputStream in, PrintStream out, char a) {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        lines = br.lines().collect(Collectors.toList());

        Comparator<String> comparator = Comparator.comparingInt(str -> countOccurrences(str, a));

        String max = lines.stream()
                .max(comparator.thenComparing(Comparator.naturalOrder()))
                .orElse("");

        PrintWriter pw = new PrintWriter(out);
        pw.println(max);
        pw.flush();
    }
}
