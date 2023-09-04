package mk.ukim.finki.napredno.exercises.vtorkolokvium.onlineshop;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

class OnlineShop {

    private Map<String, List<Product>> productsByCategory;
    private Map<String, Product> lookupProduct;

    OnlineShop() {
        productsByCategory = new HashMap<>();
        lookupProduct = new HashMap<>();
    }

    void addProduct(String category, String id, String name, LocalDateTime createdAt, double price) {
        Product product = new Product(id, name, createdAt, price);

        productsByCategory.computeIfAbsent(category, k -> new ArrayList<>()).add(product);

        lookupProduct.put(id, product);
    }

    double buyProduct(String id, int quantity) throws ProductNotFoundException {
        if (!lookupProduct.containsKey(id)) {
            throw new ProductNotFoundException(String.format("Product with id %s does not exist in the online shop!", id));
        }

        return lookupProduct.get(id).buy(quantity);
    }

    private Comparator<Product> createComparator(COMPARATOR_TYPE comparatorType) {
        Comparator<Product> byDate = Comparator.comparing(Product::getCreatedAt);
        Comparator<Product> byQuantity = Comparator.comparing(Product::getQuantitySold);
        Comparator<Product> byPrice = Comparator.comparing(Product::getPrice);

        if (comparatorType.equals(COMPARATOR_TYPE.NEWEST_FIRST))
            return byDate.reversed();
        if (comparatorType.equals(COMPARATOR_TYPE.OLDEST_FIRST))
            return byDate;
        if (comparatorType.equals(COMPARATOR_TYPE.MOST_SOLD_FIRST))
            return byQuantity.reversed();
        if (comparatorType.equals(COMPARATOR_TYPE.LEAST_SOLD_FIRST))
            return byQuantity;
        if (comparatorType.equals(COMPARATOR_TYPE.LOWEST_PRICE_FIRST))
            return byPrice;
        return byPrice.reversed();
    }

    List<List<Product>> listProducts(String category, COMPARATOR_TYPE comparatorType, int pageSize) {

        List<Product> relevantProducts;
        if (category == null) {
            relevantProducts = new ArrayList<>(lookupProduct.values());
        } else {
            relevantProducts = productsByCategory.get(category);
        }

        relevantProducts.sort(createComparator(comparatorType));

        List<List<Product>> result = new ArrayList<>(relevantProducts.stream()
                .collect(Collectors.groupingBy(
                        product -> (relevantProducts.indexOf(product) / pageSize),
                        Collectors.mapping(product -> product, Collectors.toList())))
                .values());
        return result;
    }

}