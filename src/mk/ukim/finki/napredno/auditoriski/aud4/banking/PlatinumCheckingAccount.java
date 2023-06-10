package mk.ukim.finki.napredno.auditoriski.aud4.banking;

public class PlatinumCheckingAccount extends InterestCheckingAccount {

    public static final double PLATINUM_RATE = INTEREST_RATE * 2;

    public PlatinumCheckingAccount(String accountOwner, double currentAmount) {
        super(accountOwner, currentAmount);
    }

    @Override
    public void addInterest() {
        addAmount(getCurrentAmount() * PLATINUM_RATE);
    }
}
