package mk.ukim.finki.napredno.auditoriski.aud6.box;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Box<E extends Drawable<E>>{
    private List<E> elements;
    public static Random random = new Random();

    public Box() {
        elements = new ArrayList<>();
    }
    public void add(E element){
        elements.add(element);
    }

    public boolean isEmpty(){
        return elements.isEmpty();
    }

    public E draw(){
        if (isEmpty())
            return null;
        return elements.remove(random.nextInt(elements.size()));
    }
}
