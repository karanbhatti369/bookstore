public class Book {             // Defines a new class named Book
    private String author;      // Private variable to hold the author's name, ISBN no., Price
    private long ISBN;          
    private double price;       
    private static int numberOfBooksCreated = 0; // Static variable to keep track of the number of Book objects created

    // Constructor for the Book class
    public Book(String title, String author, long ISBN, double price) { 
        this.author = author;   // Sets the author's name, ISBN Number, Price for this book.
        this.ISBN = ISBN;       
        this.price = price;     
        numberOfBooksCreated++; // Increments the static counter of created books
    }

    // Setters and Getters
    public void setTitle(String title) { // Setter for title
        this.title = title;              // Sets the title of the book
    }

    public String getTitle() { // Getter for title
        return title;          // Returns the book's title
    }

    public void setISBN(long ISBN) { // Setter for ISBN
        this.ISBN = ISBN;             // Sets the book's ISBN
    }

    public void setAuthor(String author) { // Setter for author
        this.author = author;              // Sets the book's author
    }

    public void setPrice(double price) { // Setter for price
        this.price = price;               // Sets the book's price
    }

    // Getter for ISBN
    public long getISBN() {
        return this.ISBN; // Returns the book's ISBN
    }

    // Getter for Author
    public String getAuthor() {
        return this.author; // Returns the book's author
    }

    // Getter for Price
    public double getPrice() {
        return this.price; // Returns the book's price
    }

    // Static method to find the number of books created
    public static int findNumberOfCreatedBooks() {
        return numberOfBooksCreated; // Returns the total number of Book objects created
    }

    @Override
    public boolean equals(Object obj) { // Overridden equals method for object comparison
        if (this == obj) return true;   // Check if the objects are the same
        if (obj == null || getClass() != obj.getClass()) return false; // Check if object is not null and is of the same class
        Book book = (Book) obj;        // Cast the object to Book for further comparison
        return ISBN == book.ISBN && Double.compare(book.price, price) == 0; // Compare ISBN and price for equality
    }

    @Override
    public String toString() { // Overridden toString method for representing the Book object as a String
        return "Author: " + this.author +
               "\nTitle: " + this.title +
               "\nISBN: " + this.ISBN +
               "\nPrice: $" + this.price; // Constructs and returns the string representation of the Book
    }
}

