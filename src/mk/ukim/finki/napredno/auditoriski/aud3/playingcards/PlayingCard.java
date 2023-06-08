package mk.ukim.finki.napredno.auditoriski.aud3.playingcards;

import java.util.Objects;

public class PlayingCard {
    private int rank;
    private PlayingCardType type;
    private boolean isPrinted;

    public PlayingCard(int rank, PlayingCardType type) {
        this.rank = rank;
        this.type = type;
        this.isPrinted = false; // Initialize isPrinted to false
    }

    // Getter and setter for isPrinted
    public boolean isPrinted() {
        return isPrinted;
    }

    public void setPrinted(boolean printed) {
        isPrinted = printed;
    }

    @Override
    public String toString() {
        return String.format("%d %s", rank, type.name());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayingCard that = (PlayingCard) o;
        return rank == that.rank && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, type);
    }
}
