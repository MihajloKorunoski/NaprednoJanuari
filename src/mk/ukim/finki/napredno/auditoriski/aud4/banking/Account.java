package mk.ukim.finki.napredno.auditoriski.aud4.banking;

public abstract class Account {

    private String accountOwner;
    private int id;
    private static int idSeed = 10000;
    private double currentAmount;

    private AccountType accountType;

    public Account(String accountOwner, double currentAmount) {
        this.accountOwner = accountOwner;
        this.currentAmount = currentAmount;
        this.id = idSeed++;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void addAmount(double amount) {
        currentAmount += amount;
    }

    public void withdrawAmount(double amount) throws InsufficientAmountException {
        if (currentAmount < amount)
            throw new InsufficientAmountException(currentAmount, amount);
        currentAmount -= amount;
    }

    public abstract AccountType getAccountType();

    @Override
    public String toString() {
        return String.format("%d: %s %.2f", id, accountOwner, currentAmount);
    }
}
