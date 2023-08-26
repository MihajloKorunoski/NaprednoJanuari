package mk.ukim.finki.napredno.kniga.pizzeria;

class ItemOutOfStockException extends Exception{
    private Item item;

    public ItemOutOfStockException(Item item) {
        this.item = item;
    }

    public ItemOutOfStockException() {
        this("Unknown item is out of stock");
    }

    public ItemOutOfStockException(String message) {
        super(message);
    }

    public Item getItem() {
        return item;
    }
}
