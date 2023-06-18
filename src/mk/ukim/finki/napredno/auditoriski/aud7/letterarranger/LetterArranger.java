package mk.ukim.finki.napredno.auditoriski.aud7.letterarranger;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LetterArranger {
    public static String arrangeSentence(String sentence){
        return Arrays.stream(sentence.split("\\s+"))
                .map(word -> arrangeWord(word))
                .sorted()
                .collect(Collectors.joining(" "));
    }

    private static String arrangeWord(String word) {
        return word.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
