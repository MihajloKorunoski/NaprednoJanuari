package mk.ukim.finki.napredno.kniga.bank;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

class Bank {
    private String name;
    private Account[] accounts;

    private double totalTransfers;
    private double totalProvision;

    public Bank(String name, Account[] accounts) {
        this.name = name;
        this.accounts = Arrays.copyOf(accounts, accounts.length);
        totalTransfers = 0.0;
        totalProvision = 0.0;
    }


    public boolean makeTransaction(Transaction t) {
        Optional<Account> from = findAccount(t.getFromId());
        Optional<Account> to = findAccount(t.getToId());

        if (!from.isPresent() || !to.isPresent())
            return false;

        Account fromAccount = from.get();
        Account toAccount = to.get();

        double provision = t.getProvision();
        double totalDebit = t.getAmount() + provision;

        if (fromAccount.getBalance() < totalDebit)
            return false;

        fromAccount.setBalance(fromAccount.getBalance() - totalDebit);

        if (fromAccount.getId() != toAccount.getId())
            toAccount.setBalance(toAccount.getBalance() + t.getAmount());
        else
            fromAccount.setBalance(fromAccount.getBalance() + t.getAmount());

        updateTotals(t.getAmount(), provision);

        return true;
    }

    private void updateTotals(double amount, double provision) {
        totalTransfers += amount;
        totalProvision += provision;
    }

    private Optional<Account> findAccount(long fromId) {
        return Arrays.stream(accounts)
                .filter(account -> account.getId() == fromId)
                .findAny();
    }

    public double totalTransfers() {
        return 0;
    }

    public double totalProvision() {
        return 0;
    }

    public static String toString(long amount) {
        return String.format("%.2f", amount / 100);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Name: ")
                .append(name)
                .append("\n\n");
        Arrays.stream(accounts)
                .forEach(each -> result.append(each.toString()));
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Double.compare(bank.totalTransfers, totalTransfers) == 0 && Double.compare(bank.totalProvision, totalProvision) == 0 && Objects.equals(name, bank.name) && Arrays.equals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, totalTransfers, totalProvision);
        result = 31 * result + Arrays.hashCode(accounts);
        return result;
    }

    public Account[] getAccounts() {
        return accounts;
    }
}
