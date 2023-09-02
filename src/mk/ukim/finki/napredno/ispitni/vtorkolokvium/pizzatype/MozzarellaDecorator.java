package mk.ukim.finki.napredno.ispitni.vtorkolokvium.pizzatype;

class MozzarellaDecorator extends PizzaDecorator{
    public MozzarellaDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.65;
    }
    @Override
    public String getDescription() {
        return super.getDescription() + ", mozzarella";
    }

}
