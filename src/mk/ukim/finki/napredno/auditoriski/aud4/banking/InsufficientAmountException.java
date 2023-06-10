package mk.ukim.finki.napredno.auditoriski.aud4.banking;

public class InsufficientAmountException extends Exception {
    public InsufficientAmountException(double currentAmount, double amount) {
        super(String.format("Insufficient amount: %f, amount to withdraw: %f",
                currentAmount,
                amount));
    }
}
