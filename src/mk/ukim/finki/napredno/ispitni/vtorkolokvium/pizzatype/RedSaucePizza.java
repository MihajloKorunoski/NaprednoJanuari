package mk.ukim.finki.napredno.ispitni.vtorkolokvium.pizzatype;

class RedSaucePizza implements Pizza{
    @Override
    public double getCost() {
        return 10.0;
    }

    @Override
    public String getDescription() {
        return "Red sauce pizza";
    }
}
