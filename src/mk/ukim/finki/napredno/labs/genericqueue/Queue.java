package mk.ukim.finki.napredno.labs.genericqueue;

class Queue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int count;


    public Queue() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int count() {
        return count;
    }

    public void enqueue(T element) {
        Node<T> n = new Node<>(element, null);
        if (isEmpty()) {
            tail = n;
            head = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
        count++;
    }

    public T dequeue() throws EmptyQueueException {
        T res = peek();
        head = head.getNext();
        count--;
        return res;
    }

    public T inspect() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();
        return tail.getElement();
    }

    public T peek() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();
        return head.getElement();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> walker = head;
        while (walker != null) {
            sb.append(walker.getElement()).append(" -> ");
            walker = walker.getNext();
        }
        sb.append("null");
        return sb.toString();
    }
}
