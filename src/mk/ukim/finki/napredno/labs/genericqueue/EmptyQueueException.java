package mk.ukim.finki.napredno.labs.genericqueue;

class EmptyQueueException extends Exception {
    public EmptyQueueException() {
        this("The queue is empty.");
    }

    public EmptyQueueException(String message) {
        super(message);
    }
}
