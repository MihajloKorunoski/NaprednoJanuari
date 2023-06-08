package mk.ukim.finki.napredno.auditoriski.aud3.playingcards;

public class DeckTest {
    public static void main(String[] args) {
        Deck deck = new Deck();

        // Test initial deck state
        System.out.println("Initial deck state:");
        System.out.println(deck);

        // Deal 10 cards and print them
        System.out.println("Dealing 10 cards:");
        for (int i = 0; i < 10; i++) {
            PlayingCard card = deck.dealCard();
            System.out.println("Dealt card: " + card);
        }

        // Check the remaining cards
        System.out.println("Remaining cards:");
        System.out.println(deck);

        // Shuffle the deck
        System.out.println("Shuffling the deck...");
        deck.shuffle();

        // Deal 5 more cards and print them
        System.out.println("Dealing 5 more cards after shuffling:");
        for (int i = 0; i < 5; i++) {
            PlayingCard card = deck.dealCard();
            System.out.println("Dealt card: " + card);
        }

        // Check the remaining cards
        System.out.println("Remaining cards:");
        System.out.println(deck);
    }
}
