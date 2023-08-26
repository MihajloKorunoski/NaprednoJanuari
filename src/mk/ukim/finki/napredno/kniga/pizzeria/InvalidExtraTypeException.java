package mk.ukim.finki.napredno.kniga.pizzeria;

class InvalidExtraTypeException extends Exception{
    public InvalidExtraTypeException(String message) {
        super(message);
    }

    public InvalidExtraTypeException() {
        this("Nepoznat tip");
    }
}
