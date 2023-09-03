package mk.ukim.finki.napredno.ispitni.ispitni.iknowonlinepayments;

class Item {
    private String studentIndex;
    private String itemName;
    private int price;

    public Item(String studentIndex, String itemName, int price) {
        this.studentIndex = studentIndex;
        this.itemName = itemName;
        this.price = price;
    }

    public String getStudentIndex() {
        return studentIndex;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }
}
