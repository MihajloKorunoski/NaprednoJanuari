package mk.ukim.finki.napredno.exercises.prvkolokvium.postoffice;

public class InternationalPackage extends Package {
    String region;
    final static double PRICE_PER_GRAM = 1.5;

    public InternationalPackage(String name, String address, int trackingNumber, int weight, String region) {
        super(name, address, trackingNumber, weight);
        this.region = region;
    }

    @Override
    public double price() {
        return weight * PRICE_PER_GRAM;
    }

    @Override
    public String toString() {
        return String.format("I, %s, %s", super.toString(), region);
    }
}
