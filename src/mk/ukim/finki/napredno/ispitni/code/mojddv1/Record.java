package mk.ukim.finki.napredno.ispitni.code.mojddv1;

import java.util.ArrayList;
import java.util.List;

class Record {
    String id;
    List<Item> itemList;

    public Record(String id, List<Item> itemList) {
        this.id = id;
        this.itemList = itemList;
    }

    public static Record createInstance(String input) throws AmountNotAllowedException {
        String[] parts = input.split("\\s+");
        List<Item> items = new ArrayList<>();
        String id = parts[0];
        for (int i = 1; i < parts.length; i += 2) {
            items.add(new Item(Integer.parseInt(parts[i]), parts[i + 1].charAt(0)));
        }
        int sum = items.stream().mapToInt(Item::getPrice).sum();

        if (sum > 30000)
            throw new AmountNotAllowedException(sum);
        return new Record(id, items);
    }

    public double getTaxReturn() {
        return itemList.stream().mapToDouble(Item::getTaxReturn).sum();
    }

    public int getSum() {
        return itemList.stream().mapToInt(Item::getPrice).sum();
    }

    @Override
    public String toString() {
        return String.format("%s %d %.2f", id, getSum(), getTaxReturn());
    }
}
