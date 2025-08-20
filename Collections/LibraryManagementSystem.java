import java.util.*;

class Book {
    String isbn, title, author;

    Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return isbn + ": " + title + " by " + author;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Map<String, Book> books = new HashMap<>();
        books.put("B1", new Book("B1", "Java", "Alice"));
        books.put("B2", new Book("B2", "Python", "Bob"));
        books.put("B3", new Book("B3", "C++", "Carol"));
        Set<String> issued = new HashSet<>();
        issued.add("B1");

        System.out.println("Available books:");
        for (String isbn : books.keySet()) {
            if (!issued.contains(isbn)) {
                System.out.println(books.get(isbn));
            }
        }

        String toIssue = "B2";
        if (!books.containsKey(toIssue)) {
            System.out.println("Book not found.");
        } else if (issued.contains(toIssue)) {
            System.out.println("Already issued.");
        } else {
            issued.add(toIssue);
            System.out.println("Issued: " + books.get(toIssue).title);
        }

        String toReturn = "B1";
        if (issued.remove(toReturn)) {
            System.out.println("Returned: " + toReturn);
        } else {
            System.out.println("Was not issued.");
        }
    }
}