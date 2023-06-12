package mk.ukim.finki.napredno.auditoriski.aud5.wordcounter;

import java.util.function.Consumer;

public class LineConsumer implements Consumer<String> {

    private int lines = 0;
    private int words = 0;
    private int chars = 0;
    @Override
    public void accept(String line) {
        ++lines;
        words += line.split("\\s+").length;
        chars += line.length();
    }

    @Override
    public String toString() {
        return String.format("Lines: %d\nWords: %d\nChars: %d\n\n", lines, words, chars);
    }
}
