package mk.ukim.finki.napredno.exercises.vtorkolokvium.onlineshop;

import java.time.LocalDateTime;

class Product {
    String id;
    String name;
    LocalDateTime createdAt;
    double price;
    int quantitySold;

    public Product(String id, String name, LocalDateTime createdAt, double price) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.price = price;
    }

    public double buy(int quantity) {
        quantitySold += quantity;
        return quantity * price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", price=" + price +
                ", quantitySold=" + quantitySold +
                '}';
    }
}
