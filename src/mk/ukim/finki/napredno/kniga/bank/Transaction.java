package mk.ukim.finki.napredno.kniga.bank;

import java.util.Objects;

abstract class Transaction {
    private long fromId;
    private long toId;
    private String desc;
    private double amount;

    public Transaction(long fromId, long toId, String desc, double amount) {
        this.fromId = fromId;
        this.toId = toId;
        this.desc = desc;
        this.amount = amount;
    }

    public long getFromId() {
        return fromId;
    }

    public long getToId() {
        return toId;
    }

    public double getAmount() {
        return amount;
    }

    public abstract double getProvision();

    public String getDescription() {
        return desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return fromId == that.fromId && toId == that.toId && Double.compare(that.amount, amount) == 0 && Objects.equals(desc, that.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromId, toId, desc, amount);
    }
}
