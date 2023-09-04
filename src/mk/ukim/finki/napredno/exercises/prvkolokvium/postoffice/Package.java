package mk.ukim.finki.napredno.exercises.prvkolokvium.postoffice;

abstract public class Package implements Comparable<Package> {
    String name;
    String address;
    int trackingNumber;
    int weight;

    public Package(String name, String address, int trackingNumber, int weight) {
        this.name = name;
        this.address = address;
        this.trackingNumber = trackingNumber;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %d, %d", name, address, trackingNumber, weight);
    }

    public int weight() {
        return weight;
    }

    public abstract double price();

    @Override
    public int compareTo(Package o) {
        return Double.compare(price(), o.price());
    }
}
