package mk.ukim.finki.napredno.auditoriski.aud9.birthdayparadx;

import java.util.HashSet;
import java.util.Random;
import java.util.stream.IntStream;

class Trial {
    private static final Random RANDOM = new Random();
    private int numPeople;
    private HashSet<Integer> birthdays;

    public Trial(int numPeople) {
        this.numPeople = numPeople;
        birthdays = new HashSet<>();
    }

    public boolean runTrial(){
        return IntStream.range(0,numPeople)
                .map(i -> RANDOM.nextInt(365) + 1)
                .anyMatch(birthday -> !birthdays.add(birthday));
    }
}
