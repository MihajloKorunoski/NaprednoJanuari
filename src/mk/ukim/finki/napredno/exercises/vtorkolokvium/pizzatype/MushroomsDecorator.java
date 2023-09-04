package mk.ukim.finki.napredno.exercises.vtorkolokvium.pizzatype;

class MushroomsDecorator extends PizzaDecorator{

    public MushroomsDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.75;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", mushrooms";
    }

}
