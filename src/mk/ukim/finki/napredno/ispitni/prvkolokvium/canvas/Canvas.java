package mk.ukim.finki.napredno.ispitni.prvkolokvium.canvas;

import java.util.Arrays;
import java.util.List;

public class Canvas implements Comparable<Canvas> {

    String canvasID;
    List<Square> squares;

    public Canvas(String canvasID, List<Square> squares) {
        this.canvasID = canvasID;
        this.squares = squares;
    }

    public static Canvas createCanvas(String line){
        String[] parts = line.split("\\s+");
        String id = parts[0];

        List<Square> squares = Arrays.stream(parts)
                .skip(1)
                .map(Integer::parseInt)
                .map(Square::new)
                .toList();

        return new Canvas(id, squares);
    }

    @Override
    public String toString() {
        return String.format("%s %d %d",
                canvasID,
                squares.size(),
                getSumOfPerimeters());
    }

    private int getSumOfPerimeters() {
        return squares.stream().mapToInt(Square::getPerimeter).sum();
    }

    @Override
    public int compareTo(Canvas o) {
        return Integer.compare(getSumOfPerimeters(),o.getSumOfPerimeters());
    }
}
