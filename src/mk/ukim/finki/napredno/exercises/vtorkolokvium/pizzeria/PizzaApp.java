package mk.ukim.finki.napredno.exercises.vtorkolokvium.pizzeria;

import java.util.*;

class PizzaApp {

    private Map<String, User> userByEmail;
    private Map<String, Float> revenueByPizza;
    private Map<String, Map<String, Integer>> frequenciesByUserAndPizza;

    public PizzaApp() {
        userByEmail = new HashMap<>();
        revenueByPizza = new TreeMap<>();
        frequenciesByUserAndPizza = new TreeMap<>();
    }

    public void registerUser(String email, String name, String phone) throws UserAlreadyExistsException {
        if (userByEmail.containsKey(email)) {
            throw new UserAlreadyExistsException(String.format("User with email %s already exists!", email));
        }
        User user = new User(email, name, phone);
        userByEmail.put(email, user);
    }

    public void makeOrder(String email, String pizzaName, float pizzaPrice) {
        revenueByPizza.merge(pizzaName, pizzaPrice, Float::sum);

        frequenciesByUserAndPizza.computeIfAbsent(pizzaName, k -> new HashMap<>())
                .merge(email, 1, Integer::sum);
    }

    public void printRevenueByPizza() {
        revenueByPizza.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.printf("%s %.2f\n", entry.getKey(), entry.getValue()));
    }

    public void printMostFrequentUserForPizza() {
        for (Map.Entry<String, Map<String, Integer>> entry : frequenciesByUserAndPizza.entrySet()) {
            System.out.printf("Pizza: %s\n", entry.getKey());
            Map<String, Integer> frequencyByEmail = entry.getValue();

            Optional<Integer> maxOpt = frequencyByEmail.values().stream().max(Integer::compare);

            if (maxOpt.isPresent()) {
                int maxFrequency = maxOpt.get();
                System.out.println("ID email frequency");
                frequencyByEmail.entrySet().stream()
                        .filter(e -> e.getValue() == maxFrequency)
                        .map(e -> userByEmail.get(e.getKey()))
                        .sorted(Comparator.comparing(User::getId))
                        .forEach(user -> System.out.printf("%d %s %d\n", user.getId(), user.getEmail(), maxFrequency));
            }
        }
    }
}
