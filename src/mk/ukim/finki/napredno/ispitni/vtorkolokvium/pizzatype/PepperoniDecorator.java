package mk.ukim.finki.napredno.ispitni.vtorkolokvium.pizzatype;

class PepperoniDecorator extends PizzaDecorator{

    public PepperoniDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", pepperoni";
    }
}
