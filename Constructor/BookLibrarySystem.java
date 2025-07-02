class Book {
    public String ISBN;
    protected String title; 
    private String author;     
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }
    public void displayBookInfo() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class EBook extends Book {
    private double fileSize;
    public EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }

    public void displayEBookInfo() {
        System.out.println("EBook Info:");
        System.out.println("ISBN (Public): " + ISBN);   // Accessing public member
        System.out.println("Title (Protected): " + title); // Accessing protected member
        System.out.println("File Size: " + fileSize + " MB");
        System.out.println("Author (via Getter): " + getAuthor());
    }
}

public class BookLibrarySystem {
    public static void main(String[] args) {
        Book book = new Book("978-0-13-516630-7", "Java Programming", "James Gosling");
        book.displayBookInfo();

        System.out.println();

        EBook ebook = new EBook("978-1-23-456789-0", "Effective Java", "Joshua Bloch", 5.4);
        ebook.displayEBookInfo();
    }
}
