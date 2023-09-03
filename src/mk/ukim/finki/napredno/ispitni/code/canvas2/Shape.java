package mk.ukim.finki.napredno.ispitni.code.canvas2;

class Shape {
    private final char type;
    private final double size;

    public Shape(char type, double size) {
        this.type = type;
        this.size = size;
    }

    public double getArea() {
        if (type == 'S') {
            return Math.pow(size, 2);
        } else if (type == 'C') {
            return Math.PI * Math.pow(size, 2);
        }
        return 0;
    }

    public char getType() {
        return type;
    }
}
