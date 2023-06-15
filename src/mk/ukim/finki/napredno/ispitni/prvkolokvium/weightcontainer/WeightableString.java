package mk.ukim.finki.napredno.ispitni.prvkolokvium.weightcontainer;

public class WeightableString implements Weightable {
    String word;

    public WeightableString(String word) {
        this.word = word;
    }

    @Override
    public double getWeight() {
        return word.length();
    }
}