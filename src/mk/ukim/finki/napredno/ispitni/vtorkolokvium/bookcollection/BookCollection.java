package mk.ukim.finki.napredno.ispitni.vtorkolokvium.bookcollection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class BookCollection {

    private final Comparator<Book> titleAndPriceComparator = Comparator
            .comparing(Book::getTitle)
            .thenComparing(Book::getPrice);

    private final Comparator<Book> priceComparator = Comparator
            .comparing(Book::getPrice)
            .thenComparing(Book::getTitle);

    private List<Book> books;

    public BookCollection() {
        books = new ArrayList<>();
    }

    public void printByCategory(String category) {
        books.stream()
                .filter(book -> book.category.equalsIgnoreCase(category))
                .sorted(titleAndPriceComparator)
                .forEach(System.out::println);
    }

    public List<Book> getCheapestN(int n) {
        return books.stream()
                .sorted(priceComparator)
                .limit(n)
                .collect(Collectors.toList());
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
