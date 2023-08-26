package mk.ukim.finki.napredno.kniga.canvas;

import static java.lang.Math.pow;

class Circle extends Shape {

    float radius;

    public Circle(String id, Color color, float r) {
        super(id, color);
        radius = r;
    }

    @Override
    public void scale(float scaleFactor) {
        radius *= scaleFactor;
    }

    @Override
    public float weight() {
        return (float) (Math.PI * pow(radius, 2));
    }

    @Override
    public String toString() {
        return String.format("C: %-5s%-10s%10.2f\n", id, color, weight());
    }
}
