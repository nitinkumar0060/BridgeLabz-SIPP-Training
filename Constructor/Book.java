package Constructor.Level1;

public class Book {
   
    private String title;
    private String author;
    private double price;

    public Book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0.0;
 }
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    
    public void displayBookDetails() {
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("Price : " + price);
    }

    public static void main(String[] args) {
        Book defaultBook = new Book();
        System.out.println("Default Book:");
        defaultBook.displayBookDetails();

        System.out.println();
        Book customBook = new Book("The Diary Of young girl", "Literature", 299.99);
        System.out.println("Custom Book:");
        customBook.displayBookDetails();
    }
}