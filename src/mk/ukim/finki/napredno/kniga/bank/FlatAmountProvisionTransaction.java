package mk.ukim.finki.napredno.kniga.bank;

class FlatAmountProvisionTransaction extends Transaction {

    private final double flatProvision;
    public FlatAmountProvisionTransaction(long fromId, long toId, String amount, String flatProvision) {
        super(fromId, toId, "FlatAmount", Double.parseDouble(amount.replace("$","").trim()));

        this.flatProvision = Double.parseDouble(flatProvision.replace("$","").trim());
    }
    @Override
    public double getProvision() {
        return flatProvision;
    }

    public double getFlatAmount(){
        return flatProvision;
    }
}
