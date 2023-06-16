package mk.ukim.finki.napredno.ispitni.prvkolokvium.canvas;

public class Square {
    int side;

    public Square(int side) {
        this.side = side;
    }

    public int getPerimeter() {
        return 4 * side;
    }
}
