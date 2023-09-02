package mk.ukim.finki.napredno.ispitni.vtorkolokvium.pizzatype;

import java.util.Map;

public class PizzaReceiptsTest {

    public static void printMap(Map<String, Integer> map) {
        map.forEach((k, v) -> System.out.printf("%s -> %d%n", k, v));
    }

    public static void main(String[] args) {
        PizzaReceipts pizzaReceipts = new PizzaReceipts();

        System.out.println("READING DATA FROM INPUT STREAM");
        try {
            pizzaReceipts.readOrders(System.in);
        } catch (InvalidPizzaOrder e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("TESTING printRevenueByUser");
        pizzaReceipts.printRevenueByUser(System.out);

        System.out.println("TESTING printUserOrders");
        System.out.println("Stefan");
        pizzaReceipts.printUserOrders(System.out, "Stefan");
        System.out.println("Ana");
        pizzaReceipts.printUserOrders(System.out, "Ana");
        System.out.println("Gjorgji");
        pizzaReceipts.printUserOrders(System.out, "Gjorgji");

        System.out.println("TESTING usersByPizzaIngredient");
        Map<String, Integer> pepperoniMap = pizzaReceipts.usersByPizzaIngredient("pepperoni");
        Map<String, Integer> mushroomsMap = pizzaReceipts.usersByPizzaIngredient("mushrooms");
        Map<String, Integer> mozzarellaMap = pizzaReceipts.usersByPizzaIngredient("mozzarella");

        System.out.println("PEPPERONI");
        printMap(pepperoniMap);
        System.out.println("MUSHROOMS");
        printMap(mushroomsMap);
        System.out.println("MOZZARELLA");
        printMap(mozzarellaMap);

    }
}
