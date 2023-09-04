package mk.ukim.finki.napredno.exercises.prvkolokvium.mobileoperator;

public abstract class Customer {
    String id;
    double minutes;
    int messages;
    double gbs;

    public Customer(String id, double minutes, int messages, double gbs) throws InvalidException {
        if(!IdValidator.isValid(id,7)){
            throw new InvalidException(String.format("%s is not a valid user ID", id));
        }
        this.id = id;
        this.minutes = minutes;
        this.messages = messages;
        this.gbs = gbs;
    }

    abstract double totalPrice();
    abstract double commission();
}
