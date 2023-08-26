package mk.ukim.finki.napredno.kniga.pizzeria;

import java.util.Scanner;

public class PizzaOrderTest {

    public static void main(String[] args) {
        Scanner jin = new Scanner(System.in);
        int k = jin.nextInt();
        if (k == 0) { // test order with removing
            Order order = new Order();
            while (true) {
                try {
                    String type = jin.next();
                    String name = jin.next();
                    Item item = null;
                    if (type.equals(" Pizza ")) item = new PizzaItem(name);
                    else item = new ExtraItem(name);
                    if (!jin.hasNextInt()) break;
                    order.addItem(item, jin.nextInt());
                } catch (Exception e) {
                    System.out.println(e.getClass().getSimpleName());
                }
            }

            jin.next();
            System.out.println(order.getPrice());
            order.displayOrder();
            while (jin.hasNextInt()) {
                int idx = jin.nextInt();
                try {
                    order.removeItem(idx);
                } catch (OrderLockedException e) {
                    System.out.println(e.getClass().getSimpleName());
                }
            }
            System.out.println(order.getPrice());
            order.displayOrder();
        }
        if (k == 1) { // test locking & exceptions
            Order order = new Order();
            try {
                order.lock();
            } catch (EmptyOrder e) {
                System.out.println(e.getClass().getSimpleName());
            }
            try {
                order.addItem(new ExtraItem(" Coke "), 1);
            } catch (InvalidExtraTypeException | ItemOutOfStockException | OrderLockedException e) {
                System.out.println(e.getClass().getSimpleName());
            }
            try {
                order.lock();
            } catch (EmptyOrder e) {
                System.out.println(e.getClass().getSimpleName());
            }
            try {
                order.removeItem(0);
            } catch (OrderLockedException e) {
                System.out.println(e.getClass().getSimpleName());
            }
        }
    }
}