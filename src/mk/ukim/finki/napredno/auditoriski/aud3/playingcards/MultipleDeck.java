package mk.ukim.finki.napredno.auditoriski.aud3.playingcards;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MultipleDeck {
    private Deck[] decks;

    public MultipleDeck(int numberOfDecks){
        decks = new Deck[numberOfDecks];
        decks = IntStream.range(0 ,numberOfDecks)
                .mapToObj(i -> new Deck())
                .toArray(Deck[]::new);
    }

    @Override
    public String toString() {
        return Arrays.stream(decks)
                .map(Deck::toString)
                .collect(Collectors.joining("\n"));
    }
}
