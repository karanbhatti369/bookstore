
public class Book {
    private String title;
    private String author;
    private long ISBN;
    private double price;
    private static int numberOfBooksCreated = 0;
    public Book(String title, String author, long ISBN, double price) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
        numberOfBooksCreated++;
    }
    // Setters and Getters
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    // Getter for ISBN
    public long getISBN() {
        return this.ISBN;
    }
    // Getter for Author
    public String getAuthor() {
        return this.author;
    }
    // Getter for Price
    public double getPrice() {
        return this.price;
    }
    // Similar setters and getters for author, ISBN, and price
    public static int findNumberOfCreatedBooks() {
        return numberOfBooksCreated;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return ISBN == book.ISBN && Double.compare(book.price, price) == 0;
    }
    @Override
    public String toString() {
        return "Author: " + this.author +
               "\nTitle: " + this.title +
               "\nISBN: " + this.ISBN +
               "\nPrice: $" + this.price;
    }
}