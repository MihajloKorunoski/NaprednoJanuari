package mk.ukim.finki.napredno.labs.resizablearray;

import java.util.LinkedList;

class ResizableArray<T> {

    private LinkedList<T> list;

    public LinkedList<T> getList() {
        return list;
    }

    public ResizableArray() {
        list = new LinkedList<>();
    }

    public void addElement(T element) {
        list.add(element);
    }

    public boolean removeElement(T element) {
        return list.remove(element);
    }

    public boolean contains(T element) {
        return list.contains(element);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int count() {
        return list.size();
    }

    public T elementAt(int index) {
        return list.get(index);
    }

    public Object[] toArray(){
        return list.toArray();
    }

    public static <T> void copyAll(ResizableArray<? super T> dest, ResizableArray<? extends T> src) {
        LinkedList<T> tempList = new LinkedList<>(src.getList());
        for(T item : tempList)
            dest.addElement(item);
    }

    @Override
    public String toString() {
        return list.toString() + " " + count() + " " + count();
    }
}
