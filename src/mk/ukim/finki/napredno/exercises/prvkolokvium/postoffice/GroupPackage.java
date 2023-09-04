package mk.ukim.finki.napredno.exercises.prvkolokvium.postoffice;

import java.util.ArrayList;
import java.util.List;

public class GroupPackage extends Package{

    List<Package> packages;

    public GroupPackage(String name, String address, int trackingNumber) {
        super(name, address, trackingNumber, 0);
        packages = new ArrayList<>();
    }

    void addPackage(Package p){
        packages.add(p);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("G, %d, %d\n", trackingNumber, weight()));
        packages.forEach(p -> sb.append("   ").append(p).append("\n"));
        return sb.toString();
    }

    @Override
    public int weight() {
        return packages.stream()
                .mapToInt(Package::weight)
                .sum();
    }

    @Override
    public double price() {
        return packages.stream()
                .mapToDouble(Package::price)
                .sum();
    }
}
