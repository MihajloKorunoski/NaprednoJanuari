package mk.ukim.finki.napredno.kniga.bank;

import java.util.Objects;
import java.util.Random;

class Account {
    public String name;
    public long id;
    public double balance;

    public Account(String name, String balance) {
        this.name = name;
        this.balance = Double.parseDouble(balance.replace("$","").trim());
        this.id = new Random().nextLong();
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nBalance: %.2f$\n", name, balance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && Objects.equals(name, account.name) && Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, balance);
    }
}
