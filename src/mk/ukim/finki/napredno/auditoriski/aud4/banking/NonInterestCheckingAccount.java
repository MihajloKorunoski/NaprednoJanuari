package mk.ukim.finki.napredno.auditoriski.aud4.banking;

public class NonInterestCheckingAccount extends Account{
    public NonInterestCheckingAccount(String accountOwner, double currentAmount) {
        super(accountOwner, currentAmount);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.NON_INTEREST;
    }
}
