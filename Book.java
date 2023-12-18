public class Book {
    // Private instance variables for the Book class
    private String title;  // Holds the title of the book
    private String author; // Holds the author's name
    private long ISBN;     // Stores the ISBN number of the book
    private double price;  // Stores the price of the book

    // Static variable to keep track of the number of Book objects created
    private static int numberOfBooksCreated = 0;

    // Constructor to initialize a new Book object
    public Book(String title, String author, long ISBN, double price) {
        this.title = title;             // Sets the title of the book
        this.author = author;           // Sets the author's name
        this.ISBN = ISBN;               // Sets the ISBN number
        this.price = price;             // Sets the price of the book
        numberOfBooksCreated++;         // Increments the count of books created
    }

    // Setters and Getters
    // Setter method for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter method for title
    public String getTitle() {
        return title;
    }

    // Setter method for ISBN
    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    // Setter method for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Setter method for price
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter for ISBN
    public long getISBN() {
        return this.ISBN;
    }

    // Getter for author
    public String getAuthor() {
        return this.author;
    }

    // Getter for price
    public double getPrice() {
        return this.price;
    }
    // Note: Similar setters and getters for author, ISBN, and price are included

    // Static method to find the total number of books created
    public static int findNumberOfCreatedBooks() {
        return numberOfBooksCreated;
    }

    // Overridden equals method to compare two Book objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Check if it's the same object
        if (obj == null || getClass() != obj.getClass()) return false; // Check for null and compare classes
        Book book = (Book) obj;        // Type cast obj to Book
        return ISBN == book.ISBN && Double.compare(book.price, price) == 0; // Compare ISBN and price
    }

    // Overridden toString method to provide a string representation of the Book object
    @Override
    public String toString() {
        return "Author: " + this.author +
               "\nTitle: " + this.title +
               "\nISBN: " + this.ISBN +
               "\nPrice: $" + this.price;
    }
}
