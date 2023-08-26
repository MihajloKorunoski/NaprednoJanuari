package mk.ukim.finki.napredno.kniga.pizzeria;

class EmptyOrder extends Exception {
    public EmptyOrder() {
        this("The order must not be empty");
    }

    public EmptyOrder(String message) {
        super(message);
    }
}
