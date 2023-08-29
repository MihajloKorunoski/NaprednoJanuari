package mk.ukim.finki.napredno.labs.doublematrix;

class InsufficientElementsException extends Exception {

    public InsufficientElementsException() {
        super("Insufficient number of elements");
    }
}
