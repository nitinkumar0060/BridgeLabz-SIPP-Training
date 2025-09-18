import java.util.*;
import java.util.stream.*;

class Book {
    String title, genre;
    int pages;
    Book(String title, String genre, int pages) {
        this.title = title; this.genre = genre; this.pages = pages;
    }
}

public class BookStatistics {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Book A", "Fiction", 300),
            new Book("Book B", "Fiction", 250),
            new Book("Book C", "Science", 400),
            new Book("Book D", "Science", 350),
            new Book("Book E", "History", 500)
        );

        Map<String, IntSummaryStatistics> stats = books.stream()
            .collect(Collectors.groupingBy(b -> b.genre,
                     Collectors.summarizingInt(b -> b.pages)));

        stats.forEach((genre, stat) -> 
            System.out.println(genre + " -> " + stat));
    }
}
