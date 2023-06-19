package mk.ukim.finki.napredno.ispitni.vtorkolokvium.bookcollection;

import java.util.Objects;

class Book {
    String title;
    String category;
    float price;


    public Book(String title, String category, float price) {
        this.title = title;
        this.category = category;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) %.2f", getTitle(), getCategory(), getPrice());
    }

    public String getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Float.compare(book.price, price) == 0 && Objects.equals(title, book.title) && Objects.equals(category, book.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, category, price);
    }
}
