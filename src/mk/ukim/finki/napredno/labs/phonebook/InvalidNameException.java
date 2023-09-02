package mk.ukim.finki.napredno.labs.phonebook;

class InvalidNameException extends Exception{
    String name;
    Reason reason;

    public enum Reason{
        NOT_UNIQUE, INVALID_CHARACTER,INVALID_SIZE
    }

    public InvalidNameException(String name, Reason reason) {
        this.name = name;
        this.reason = reason;
    }

    public String getName() {
        return name;
    }

    public Reason getReason() {
        return reason;
    }
}
