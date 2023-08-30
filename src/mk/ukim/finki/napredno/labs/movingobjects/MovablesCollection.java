package mk.ukim.finki.napredno.labs.movingobjects;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

class MovablesCollection {

    static int X_MAX;
    static int Y_MAX;
    List<Movable> movableList;

    public MovablesCollection(int x_MAX, int y_MAX) {
        movableList = new ArrayList<>();
        X_MAX = x_MAX;
        Y_MAX = y_MAX;
    }

    public static void setxMax(int i) {
        X_MAX = i;
    }

    public static void setyMax(int i) {
        Y_MAX = i;
    }

    public void addMovableObject(Movable m) throws MovableObjectNotFittableException {

        if (!m.canBeFitted(X_MAX, Y_MAX))
            throw new MovableObjectNotFittableException(m.exceptionMessage());
        movableList.add(m);
    }

    public void moveObjectsFromTypeWithDirection(TYPE type, DIRECTION direction) {
        Map<DIRECTION, Consumer<Movable>> actionMap = new HashMap<>();
        actionMap.put(DIRECTION.UP, movable -> {
            try {
                movable.moveUp();
            } catch (ObjectCanNotBeMovedException e) {
                System.out.println(e.getMessage());
            }
        });
        actionMap.put(DIRECTION.DOWN, movable -> {
            try {
                movable.moveDown();
            } catch (ObjectCanNotBeMovedException e) {
                System.out.println(e.getMessage());
            }
        });
        actionMap.put(DIRECTION.LEFT, movable -> {
            try {
                movable.moveLeft();
            } catch (ObjectCanNotBeMovedException e) {
                System.out.println(e.getMessage());
            }
        });
        actionMap.put(DIRECTION.RIGHT, movable -> {
            try {
                movable.moveRight();
            } catch (ObjectCanNotBeMovedException e) {
                System.out.println(e.getMessage());
            }
        });

        movableList.stream()
                .filter(movable -> movable.getType().equals(type))
                .forEach(actionMap.get(direction));

    }

    @Override
    public String toString() {
        String details = movableList.stream()
                .map(Objects::toString)
                .collect(Collectors.joining("\n"));

        return String.format("Collection of movable objects with size %d:\n%s",
                movableList.size(),
                details);
    }
}
