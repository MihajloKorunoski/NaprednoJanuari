package mk.ukim.finki.napredno.kniga.bank;

class FlatAmountProvisionTransaction extends Transaction {

    private final double flatProvision;
    public FlatAmountProvisionTransaction(long fromId, long toId, double amount, double flatProvision) {
        super(fromId, toId, "FlatAmount", amount);

        this.flatProvision = flatProvision;
    }
    @Override
    public double getProvision() {
        return flatProvision;
    }

    public double getFlatAmount(){
        return flatProvision;
    }
}
