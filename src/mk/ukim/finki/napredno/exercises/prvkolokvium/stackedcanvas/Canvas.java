package mk.ukim.finki.napredno.exercises.prvkolokvium.stackedcanvas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Canvas {

    List<Shape> shapes;

    public Canvas() {
        shapes = new ArrayList<>();
    }

    private int findPosition(float weight) {
        return (int) shapes.stream()
                .filter(shape -> shape.weight() >= weight)
                .count();
    }

    public void add(String id, Color color, float radius) {
        Circle circle = new Circle(id, color, radius);
        int position = findPosition(circle.weight());
        shapes.add(position, circle);
    }

    public void add(String id, Color color, float width, float height) {
        Rectangle rectangle = new Rectangle(id, color, width, height);
        int position = findPosition(rectangle.weight());
        shapes.add(position, rectangle);
    }

    public void scale(String id, float scaleFactor) {
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i).id.equals(id)) {
                Shape shape = shapes.remove(i);
                shape.scale(scaleFactor);
                int position = findPosition(shape.weight());
                shapes.add(position, shape);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return shapes.stream()
                .map(Shape::toString)
                .collect(Collectors.joining("\n")) + "\n";
    }
}
