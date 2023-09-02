package mk.ukim.finki.napredno.ispitni.vtorkolokvium.pizzatype;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.*;

class PizzaReceipts {
    private Map<String, List<Pizza>> orders = new HashMap<>();

    public void readOrders(InputStream is) throws InvalidPizzaOrder {
        Scanner sc = new Scanner(is);
        while (sc.hasNextLine()) {
            String[] parts = sc.nextLine().split("\\s+");
            String user = parts[0];
            String[] pizzaDetails = parts[1].split(";");
            Pizza pizza = createPizza(pizzaDetails);
            orders.computeIfAbsent(user, k -> new ArrayList<>()).add(pizza);
        }
        sc.close();
    }

    private Pizza createPizza(String[] pizzaDetails) throws InvalidPizzaOrder {
        Pizza pizza;
        if ("whiteSauce".equals(pizzaDetails[0]))
            pizza = new WhiteSaucePizza();
        else if ("redSauce".equals(pizzaDetails[0]))
            pizza = new RedSaucePizza();
        else
            throw new InvalidPizzaOrder("Invalid base sauce");
        Map<String, Integer> toppingsCount = new HashMap<>();
        for (int i = 1; i < pizzaDetails.length; i++) {
            String topping = pizzaDetails[i];
            toppingsCount.put(topping, toppingsCount.getOrDefault(topping, 0) + 1);
            if (toppingsCount.get(topping) > 2 || pizzaDetails.length - 1 > 6)
                throw new InvalidPizzaOrder("Invalid toppings");
            switch (topping) {
                case "pepperoni":
                    pizza = new PepperoniDecorator(pizza);
                    break;
                case "mushrooms":
                    pizza = new MushroomsDecorator(pizza);
                    break;
                case "mozzarella":
                    pizza = new MozzarellaDecorator(pizza);
                    break;
                default:
                    throw new InvalidPizzaOrder("Unknown topping: " + topping);
            }
        }
        return pizza;
    }

    void printRevenueByUser(OutputStream os) {
        PrintWriter pw = new PrintWriter(os);
        DecimalFormat df = new DecimalFormat("#.##");
        Map<String, Double> revenueByUser = new HashMap<>();
        Map<String, Integer> countByUser = new HashMap<>();

        for (Map.Entry<String, List<Pizza>> entry : orders.entrySet()) {
            String user = entry.getKey();
            List<Pizza> userPizzas = entry.getValue();
            double totalForUser = 0.0;
            for (Pizza p : userPizzas) {
                totalForUser += p.getCost();
            }
            revenueByUser.put(user, totalForUser);
            countByUser.put(user, userPizzas.size());
        }
        revenueByUser.entrySet().stream()
                .sorted(getEntryComparator(countByUser))
                .forEach(e -> {
                            String user = e.getKey();
                            double total = e.getValue();
                            int count = countByUser.get(user);
                            pw.println(user
                                    + " "
                                    + count
                                    + " "
                                    + df.format(total / count)
                                    + "$"
                                    + total);
                        }
                );
        pw.println("Total revenue " + df.format(revenueByUser.values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum()) + "$");
        pw.flush();
    }

    private static Comparator<Map.Entry<String, Double>> getEntryComparator(Map<String, Integer> countByUser) {
        return (e1, e2) -> Double.compare(e2.getValue() / countByUser.get(e2.getKey()),
                e1.getValue() / countByUser.get(e1.getKey()));
    }

    void printUserOrders(OutputStream os, String user) {
        PrintWriter pw = new PrintWriter(os);
        List<Pizza> userOrders = orders.getOrDefault(user, new ArrayList<>());
        userOrders.stream()
                .sorted(Comparator.comparingDouble(Pizza::getCost).reversed())
                .forEach(p -> pw.println("Pizza description: "
                        + p.getDescription()
                        + " Price: "
                        + String.format("%.2f$", p.getCost())));
        pw.flush();
    }

    Map<String, Integer> usersByPizzaIngredient(String ingredient) {
        Map<String, Integer> usersByIngredient = new HashMap<>();
        for (Map.Entry<String, List<Pizza>> entry : orders.entrySet()){
            String user = entry.getKey();
            List<Pizza> pizzas = entry.getValue();
            int count =(int) pizzas.stream().filter(p -> p.getDescription().contains(ingredient)).count();
            if(count > 0)
                usersByIngredient.put(user, count);
        }
        return usersByIngredient;
    }
}
