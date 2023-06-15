package mk.ukim.finki.napredno.ispitni.prvkolokvium.postoffice;

public class LocalPackage extends Package{
    boolean priority;
    final static double PRICE_WITH_PRIORITY = 5.0;
    final static double REGULAR_PRICE = 3.0;

    @Override
    public double price() {
        return priority ?
                PRICE_WITH_PRIORITY :
                REGULAR_PRICE;
    }

    public LocalPackage(String name, String address, int trackingNumber, int weight, boolean priority) {
        super(name, address, trackingNumber, weight);
        this.priority = priority;
    }

    @Override
    public String toString() {
        return String.format("L, %s, %s", super.toString(), priority);
    }

}
