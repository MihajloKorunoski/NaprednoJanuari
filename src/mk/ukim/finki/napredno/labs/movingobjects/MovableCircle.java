package mk.ukim.finki.napredno.labs.movingobjects;

class MovableCircle implements Movable {

    private int radius;
    private MovablePoint center;

    public MovableCircle(int radius, MovablePoint center) {
        this.radius = radius;
        this.center = center;
    }

    @Override
    public void moveUp() throws ObjectCanNotBeMovedException {
        center.moveUp();
    }

    @Override
    public void moveDown() throws ObjectCanNotBeMovedException {
        center.moveDown();
    }

    @Override
    public void moveRight() throws ObjectCanNotBeMovedException {
        center.moveRight();
    }

    @Override
    public void moveLeft() throws ObjectCanNotBeMovedException {
        center.moveLeft();
    }

    @Override
    public int getCurrentXPosition() {
        return center.getCurrentXPosition();
    }

    @Override
    public int getCurrentYPosition() {
        return center.getCurrentYPosition();
    }

    @Override
    public TYPE getType() {
        return TYPE.CIRCLE;
    }

    @Override
    public boolean canBeFitted(int xMax, int yMax) {
        return (center.getCurrentXPosition() - radius) >= 0
                && (center.getCurrentXPosition() + radius) <= xMax
                && (center.getCurrentYPosition() - radius) >= 0
                && (center.getCurrentYPosition() + radius) <= yMax;
    }

    @Override
    public String exceptionMessage() {
        return String.format("Movable circle with center (%d,%d) and radius %d can not be fitted into the collection",
                center.getCurrentXPosition(),
                center.getCurrentYPosition(),
                radius);
    }

    @Override
    public String toString() {
        return String.format("Movable circle with center coordinates (%d,%d) and radius %d",
                center.getCurrentXPosition(),
                center.getCurrentYPosition(),
                radius);
    }
}
