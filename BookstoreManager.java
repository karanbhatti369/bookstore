import java.util.Scanner;
import java.util.InputMismatchException;

public class BookstoreManager {

    private static final String PASSWORD = "pargol";
    private static Book[] inventory;
    private static Scanner scanner = new Scanner(System.in);
    private static int totalPasswordAttempts = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the Bookstore Manager!");

        int maxBooks = readInt("Enter the maximum number of books: ", 1, Integer.MAX_VALUE);
        inventory = new Book[maxBooks];

        int choice;
        do {
            printMenuOptions();
            choice = readInt("", 1, 5);
            processMenuChoice(choice);
        } while (choice != 5);

        System.out.println("Thank you for using Bookstore Manager. Goodbye!");
    }

    private static void printMenuOptions() {
        System.out.println("\nWhat do you want to do?");
        System.out.println("1. Enter new books (password required)");
        System.out.println("2. Change information of a book (password required)");
        System.out.println("3. Display all books by a specific author");
        System.out.println("4. Display all books under a certain a price.");
        System.out.println("5. Quit");
        System.out.print("Please enter your choice > ");
    }

    private static void processMenuChoice(int choice) {
        switch (choice) {
            case 1:
                addBooksToInventory();
                break;
            case 2:
                changeBookInformation();
                break;
            case 3:
                displayBooksByAuthor();
                break;
            case 4:
                displayBooksUnderPrice();
                break;
            
        }
    }

    // Password Verification Method
    private static boolean isPasswordCorrect() {
        final int MAX_ATTEMPTS_PER_SESSION = 3;
        final int MAX_TOTAL_ATTEMPTS = 12;

        for (int attempts = 0; attempts < MAX_ATTEMPTS_PER_SESSION; attempts++) {
            System.out.print("Enter password: ");
            String inputPassword = scanner.next();

            if (inputPassword.equals(PASSWORD)) {
                return true;
            } else {
                System.out.println("Incorrect password. Please try again.");
                totalPasswordAttempts++;
                if (totalPasswordAttempts >= MAX_TOTAL_ATTEMPTS) {
                    System.out.println("Program detected suspicious activities and will terminate immediately!");
                    System.exit(0); // Terminates the program
                }
            }
        }
        return false;
    
    }

    // Book Management Methods
    private static void addBooksToInventory() {
        if (!isPasswordCorrect()) {
            return;
        }

        int numBooksToAdd = readInt("How many books do you want to add? ", 1, Integer.MAX_VALUE);
        int spaceAvailable = inventory.length - Book.findNumberOfCreatedBooks();

        if (numBooksToAdd > spaceAvailable) {
            System.out.println("Not enough space. You can only add up to " + spaceAvailable + " more books.");
            return;
        }

        for (int i = 0; i < numBooksToAdd; i++) {
            System.out.println("Enter details for book " + (i + 1) + ":");
            
         
            String title = readNonNumericString("Title: ");

           
            String author = readNonNumericString("Author: ");

            long isbn = readLong("ISBN: ", 0, Long.MAX_VALUE);
            double price = readDouble("Price: ", 0, Double.MAX_VALUE);

            inventory[Book.findNumberOfCreatedBooks()] = new Book(title, author, isbn, price);
        }
    }

    private static void changeBookInformation() {
        if (!isPasswordCorrect()) {
            return;
        }

        System.out.print("Enter the book number you wish to update: ");
        int bookNumber = readInt("", 0, inventory.length - 1);

        if (inventory[bookNumber] == null) {
            System.out.println("No book found at this number. Returning to main menu.");
            return;
        }

        Book bookToEdit = inventory[bookNumber];
        System.out.println("Current information of the book:");
        System.out.println(bookToEdit);

        int attributeToChange;
        do {
            System.out.println("What information would you like to change?");
            System.out.println("1. Author");
            System.out.println("2. Title");
            System.out.println("3. ISBN");
            System.out.println("4. Price");
            System.out.println("5. Quit");
            System.out.print("Enter your choice > ");

            attributeToChange = readInt("", 1, 5);
            switch (attributeToChange) {
                case 1:
                    bookToEdit.setAuthor(readNonNumericString("Enter new author: "));
                    break;
                case 2:
                    bookToEdit.setTitle(readNonNumericString("Enter new title: "));
                    break;
                case 3:
                    bookToEdit.setISBN(readLong("Enter new ISBN: ", 0, Long.MAX_VALUE));
                    break;
                case 4:
                    bookToEdit.setPrice(readDouble("Enter new price: ", 0, Double.MAX_VALUE));
                    break;
            }
          if(attributeToChange != 5) {  
//            
           System.out.println(bookToEdit);}
        } 
        while (attributeToChange != 5);
    }

  //gavin will add display book by author method 

  //gavin will add display books underprice
        
    
   //gavin will add find books by author   

    // Input Reading Helper Methods
    private static int readInt(String prompt, int min, int max) {
        int number;
        while (true) {
            try {
                System.out.print(prompt);
                number = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }

    //gavin will add other input reading helper method


}
