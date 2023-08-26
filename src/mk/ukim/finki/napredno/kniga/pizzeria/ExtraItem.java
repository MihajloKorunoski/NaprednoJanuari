package mk.ukim.finki.napredno.kniga.pizzeria;

class ExtraItem implements Item {

    private ExtraType type;
    public ExtraItem(String name) throws InvalidExtraTypeException {
        try {
            this.type = ExtraType.valueOf(name);
        }
        catch (IllegalArgumentException e){
            throw new InvalidExtraTypeException(name);
        }

    }

    public ExtraItem(ExtraType type) {
        this.type = type;
    }

    @Override
    public int getPrice() {
        return type.getCost();
    }

    @Override
    public boolean isPizza() {
        return false;
    }

    @Override
    public String getType() {
        return type.name();
    }
}
