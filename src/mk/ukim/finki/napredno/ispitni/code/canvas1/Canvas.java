package mk.ukim.finki.napredno.ispitni.code.canvas1;

import java.util.List;

class Canvas {
    String canvasID;
    List<Integer> squares;

    public Canvas(String canvasID, List<Integer> squares) {
        this.canvasID = canvasID;
        this.squares = squares;
    }

    int getSquaresCount() {
        return squares.size();
    }

    int getTotalPerimeter() {
        return squares.stream()
                .mapToInt(size -> 4 * size)
                .sum();
    }
}
