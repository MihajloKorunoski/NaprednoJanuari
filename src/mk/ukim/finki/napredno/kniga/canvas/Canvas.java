package mk.ukim.finki.napredno.kniga.canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Canvas {
    List<Shape> shapes;


    public Canvas() {
        this.shapes = new ArrayList<>();
    }

    private int find(float weight) {
        return IntStream.range(0, shapes.size())
                .filter(i -> shapes.get(i).weight() < weight)
                .findFirst()
                .orElse(shapes.size());
    }

    public void add(String id, Color color, float radius) {
        Circle c = new Circle(id, color, radius);
        int index = find(c.weight());
        this.shapes.add(index, c);
    }

    public void add(String id, Color color, float width, float height) {
        Rectangle c = new Rectangle(id, color, width, height);
        int index = find(c.weight());
        this.shapes.add(index, c);
    }

    public void scale(String id, float scaleFactor) {
        Optional<Shape> optionalShape = shapes.stream()
                .filter(shape -> shape.id.equals(id))
                .findFirst();
        if (optionalShape.isPresent()) {
            Shape s = optionalShape.get();
            shapes.remove(s);
            s.scale(scaleFactor);
            int index = find(s.weight());
            shapes.add(index, s);
        }
    }

    public String toString() {
        return shapes.stream()
                .map(Shape::toString)
                .collect(Collectors.joining());
    }
}
