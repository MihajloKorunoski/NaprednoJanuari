package mk.ukim.finki.napredno.kniga.pizzeria;

class PizzaItem implements Item {
    private PizzaType type;
    public PizzaItem(String name) throws InvalidPizzaTypeException {
        try {
            this.type = PizzaType.valueOf(name);
        }
        catch (IllegalArgumentException e){
            throw new InvalidPizzaTypeException();
        }
    }

    @Override
    public int getPrice() {
        return type.getCost();
    }

    @Override
    public boolean isPizza() {
        return true;
    }

    @Override
    public String getType() {
        return type.name();
    }
}
