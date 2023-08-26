package mk.ukim.finki.napredno.auditoriski.aud9.birthdayparadx;

import java.text.DecimalFormat;
import java.util.stream.IntStream;

class BirthdayParadox {
    private final int maxPeople;
    private static final int TRIALS = 10000;

    public BirthdayParadox(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public void conductExperiment() {
        IntStream.rangeClosed(2, maxPeople)
                .forEach(this::runSimulation);
    }

    private void runSimulation(int numberOfPeople) {
        double probability = IntStream.range(0, TRIALS)
                .mapToObj(i ->  new Trial(numberOfPeople))
                .filter(Trial::runTrial)
                .count() * 1.0 / TRIALS;
        DecimalFormat decimalFormat = new DecimalFormat("#.#####");
        System.out.printf("For %3d people, the probability of two birthdays is about %s\n"
                ,numberOfPeople
                ,decimalFormat.format(probability));
    }
}
