package mk.ukim.finki.napredno.kniga.pizzeria;

enum PizzaType {
    Standard(0), Peperoni(1), Extra_cheese(2), Vegetarian(3);
    private int value;
    private int cost;

    PizzaType(int value) {
        this.value = value;
        switch (value) {
            case 0 -> cost = 10;
            case 1 -> cost = 12;
            case 2 -> cost = 15;
            case 3 -> cost = 8;
        }
    }

    public int getValue() {
        return value;
    }

    public int getCost() {
        return cost;
    }
}
