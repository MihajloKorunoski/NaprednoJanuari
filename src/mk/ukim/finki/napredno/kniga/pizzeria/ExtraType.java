package mk.ukim.finki.napredno.kniga.pizzeria;

enum ExtraType {
    Coke(0) , OrangeJuice(1), Ketchup(2);

    private int cost;
    private int value;

    ExtraType(int value) {
        this.value = value;
        if(value == 0)
            cost = 5;
        if(value == 1)
            cost = 8;
        if(value == 2)
            cost = 3;
    }

    public int getValue(){
        return value;
    }

    public int getCost() {
        return cost;
    }
}
