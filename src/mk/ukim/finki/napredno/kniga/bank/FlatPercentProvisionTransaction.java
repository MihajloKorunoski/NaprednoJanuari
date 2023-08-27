package mk.ukim.finki.napredno.kniga.bank;

class FlatPercentProvisionTransaction extends Transaction {
    private final int centsPerDollar;
    public FlatPercentProvisionTransaction(long fromId, long toId, String amount, int centsPerDollar) {
        super(fromId, toId, "FlatPercent", Double.parseDouble(amount.replace("$","").trim()));
        this.centsPerDollar = centsPerDollar;
    }

    @Override
    public double getProvision() {
        return centsPerDollar * getAmount() / 100;
    }

    public int getPercent(){
        return centsPerDollar;
    }
}
