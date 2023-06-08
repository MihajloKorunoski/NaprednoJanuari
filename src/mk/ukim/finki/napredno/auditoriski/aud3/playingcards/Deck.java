package mk.ukim.finki.napredno.auditoriski.aud3.playingcards;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Deck {
    private PlayingCard[] cards;
    private boolean[] isDealt;
    private int dealtTotal;
    private Random random;

    public Deck() {
        cards = new PlayingCard[52];
        isDealt = new boolean[52];
        dealtTotal = 0;
        random = new Random();

        for (int type = 0; type < PlayingCardType.values().length; type++) {
            for (int rank = 0; rank < 13; rank++) {
                cards[type * 13 + rank] = new PlayingCard(rank + 2, PlayingCardType.values()[type]);
            }
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deck deck = (Deck) o;
        return dealtTotal == deck.dealtTotal && Arrays.equals(cards, deck.cards) && Arrays.equals(isDealt, deck.isDealt);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(dealtTotal);
        result = 31 * result + Arrays.hashCode(cards);
        result = 31 * result + Arrays.hashCode(isDealt);
        return result;
    }

    @Override
    public String toString() {
        return Arrays.stream(cards)
                .filter(card -> !card.isPrinted())
                .map(PlayingCard::toString)
                .collect(Collectors.joining("\n"));
    }

    public boolean hasCardsLeft() {
        return (cards.length - dealtTotal) > 0;
    }

    public PlayingCard dealCard() {
        if (!hasCardsLeft()) {
            return null;
        }

        shuffleIfNeeded();

        int cardIndex = getNextUndealtCardIndex();
        PlayingCard card = cards[cardIndex];
        card.setPrinted(true);
        isDealt[cardIndex] = true;
        dealtTotal++;
        return card;
    }

    private void shuffleIfNeeded() {
        if (dealtTotal >= cards.length) {
            shuffle();
            dealtTotal = 0;
            Arrays.fill(isDealt, false); // Reset the isDealt array
        }
    }

    private int getNextUndealtCardIndex() {
        return IntStream.generate(() -> random.nextInt(cards.length))
                .filter(cardIndex -> !isDealt[cardIndex])
                .findFirst()
                .orElseThrow();
    }

    public void shuffle() {
        List<PlayingCard> cardList = Arrays.asList(cards);
        Collections.shuffle(cardList, random);
        cards = cardList.toArray(new PlayingCard[0]);
    }
}

