package mk.ukim.finki.napredno.exercises.vtorkolokvium.pizzeria;

import java.util.Scanner;

public class PizzaAppTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PizzaApp pizzaApp = new PizzaApp();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split("\\s+");

            String method = parts[0];

            if (method.equalsIgnoreCase("registerUser")) { //email, name, phone
                String email = parts[1];
                String name = parts[2];
                String phone = parts[3];
                try {
                    pizzaApp.registerUser(email, name, phone);
                } catch (UserAlreadyExistsException e) {
                    System.out.println(e.getMessage());
                }
            } else if (method.equalsIgnoreCase("makeOrder")) { //email, pizzaName, price
                String email = parts[1];
                String pizzaName = parts[2];
                float price = Float.parseFloat(parts[3]);
                pizzaApp.makeOrder(email, pizzaName, price);
            } else if (method.equalsIgnoreCase("printRevenueByPizza")) {
                System.out.println("Print revenue by pizza");
                pizzaApp.printRevenueByPizza();
            } else { //printMostFrequentUserForPizza
                System.out.println("Print most frequent user(s) by pizza");

                pizzaApp.printMostFrequentUserForPizza();
            }
        }
    }
}
