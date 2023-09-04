package mk.ukim.finki.napredno.exercises.vtorkolokvium.pizzatype;

class WhiteSaucePizza implements Pizza{

    @Override
    public double getCost() {
        return 11.0;
    }

    @Override
    public String getDescription() {
        return "White sauce pizza";
    }
}
