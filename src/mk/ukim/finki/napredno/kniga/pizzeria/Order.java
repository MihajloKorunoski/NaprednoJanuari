package mk.ukim.finki.napredno.kniga.pizzeria;

import java.util.ArrayList;

class Order {

    private class OrderItem {
        private final Item item;
        private int count;

        public Item getItem() {
            return item;
        }

        public int getCount() {
            return count;
        }

        public OrderItem(Item item, int count) {
            this.item = item;
            this.count = count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getPrice() {
            return getItem().getPrice() * getCount();
        }
    }

    private ArrayList<OrderItem> items;
    private boolean locked;

    public Order() {
        items = new ArrayList<>();
        locked = false;
    }

    public void addItem(Item item, int count) throws OrderLockedException, ItemOutOfStockException {
        if (locked)
            throw new OrderLockedException();
        if (count > 10)
            throw new ItemOutOfStockException(item);

        items.stream()
                .filter(each -> each.getItem().getType().equals(item.getType()))
                .findFirst()
                .ifPresentOrElse(
                        existingOrderItem -> existingOrderItem.setCount(count),
                        () -> items.add(new OrderItem(item, count))
                );
    }

    public int getPrice() {
        return items.stream()
                .mapToInt(OrderItem::getPrice)
                .sum();
    }

    public void displayOrder() {

        for (int i = 0; i < items.size(); i++) {
            OrderItem order = items.get(i);
            System.out.printf("%3d.%-15s x %2d %5d$\n",
                    i + 1,
                    order.getItem().getType(),
                    order.getCount(),
                    order.getPrice());
        }
        System.out.printf("%-22s%5d$\n", "Total:", getPrice());
    }

    public void removeItem(int idx) throws OrderLockedException {
        if (locked)
            throw new OrderLockedException();
        items.remove(idx);
    }

    public void lock() throws EmptyOrder {
        if (items.isEmpty())
            throw new EmptyOrder();
        locked = true;
    }
}
