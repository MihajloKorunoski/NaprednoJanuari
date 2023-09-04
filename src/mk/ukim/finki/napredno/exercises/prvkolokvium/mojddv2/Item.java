package mk.ukim.finki.napredno.exercises.prvkolokvium.mojddv2;

class Item {
    int price;
    char type;

    public Item(int price, char type) {
        this.price = price;
        this.type = type;
    }

    public double getTaxReturn() {
        switch (type) {
            case 'A':
                return price * 0.18 * 0.15;
            case 'B':
                return price * 0.05 * 0.15;
            default:
                return 0;
        }
    }

    public int getPrice() {
        return price;
    }
}
