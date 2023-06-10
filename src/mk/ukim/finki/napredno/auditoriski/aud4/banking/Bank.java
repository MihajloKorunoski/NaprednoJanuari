package mk.ukim.finki.napredno.auditoriski.aud4.banking;

import java.util.Arrays;

public class Bank {

    private Account[] accounts;
    private int totalAccounts;
    private int maxAccounts;

    public Bank(int maxAccounts) {
        this.maxAccounts = maxAccounts;
        this.accounts = new Account[maxAccounts];
        this.totalAccounts = 0;
    }

    public void addAccount(Account account) {
        if (totalAccounts == maxAccounts) {
            accounts = Arrays.copyOf(accounts, maxAccounts * 2);
            maxAccounts *= 2;
        }
        accounts[totalAccounts++] = account;
    }

    public double totalAssets(){
        return Arrays.stream(accounts)
                .mapToDouble(Account::getCurrentAmount)
                .sum();
    }
    public void addInterestToAllAccounts(){
        Arrays.stream(accounts)
                .filter(account -> account.getAccountType().equals(AccountType.INTEREST))
                .map(account -> (InterestBearingAccount) account)
                .forEach(InterestBearingAccount::addInterest);
    }
}
