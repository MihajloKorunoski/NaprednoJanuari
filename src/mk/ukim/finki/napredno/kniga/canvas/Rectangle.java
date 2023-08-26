package mk.ukim.finki.napredno.kniga.canvas;

class Rectangle extends Shape {
    float width, height;

    public Rectangle(String id, Color color, float w, float h) {
        super(id, color);
        width = w;
        height = h;
    }

    @Override
    public void scale(float scaleFactor) {
        width *= scaleFactor;
        height *= scaleFactor;
    }

    @Override
    public float weight() {
        return width * height;
    }

    @Override
    public String toString() {
        return String.format("R: %-5s%-10s%10.2f\n", id, color, weight());
    }
}
