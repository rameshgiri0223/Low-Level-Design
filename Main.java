import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Library library;

    public static void main(String[] args) {
        System.out.println("Welcome to the Library Management System!");

        // Initialize the library with a number of racks
        System.out.print("Enter the number of racks in the library: ");
        int numberOfRacks = Integer.parseInt(scanner.nextLine());
        library = new Library(numberOfRacks);

        // Sample interaction loop
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a Book");
            System.out.println("2. Remove a Book Copy");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Search for Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBookCopy();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    searchBooks();
                    break;
                case 6:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter Book ID: ");
        int bookId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Authors: ");
        String authors = scanner.nextLine();
        System.out.print("Enter Publisher: ");
        String publisher = scanner.nextLine();

        Book book = new Book(bookId, title, authors, publisher);
        library.addBook(book);
        System.out.println("Book added successfully!");
    }

    private static void removeBookCopy() {
        System.out.print("Enter Book Copy ID to remove: ");
        int bookCopyId = Integer.parseInt(scanner.nextLine());
        library.removeBookCopy(bookCopyId);
    }

    private static void borrowBook() {
        System.out.print("Enter Book ID: ");
        int bookId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter User ID: ");
        int userId = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Due Date (format: yyyy-mm-dd): ");
        String dueDateStr = scanner.nextLine();

        // Parse the due date using LocalDate and DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dueDate;
        try {
            dueDate = LocalDate.parse(dueDateStr, formatter);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd format.");
            return;
        }

        // Proceed to borrow the book
        library.borrowBook(bookId, userId, dueDate);
    }

    private static void returnBook() {
        System.out.print("Enter Book Copy ID: ");
        int bookCopyId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter User ID: ");
        int userId = Integer.parseInt(scanner.nextLine());

        library.returnBook(bookCopyId, userId);
    }

    private static void searchBooks() {
        System.out.print("Enter Title (or leave blank to skip): ");
        String title = scanner.nextLine();
        System.out.print("Enter Author (or leave blank to skip): ");
        String author = scanner.nextLine();
        System.out.print("Enter Publisher (or leave blank to skip): ");
        String publisher = scanner.nextLine();

        library.searchBooks(title.isEmpty() ? null : title, author.isEmpty() ? null : author, publisher.isEmpty() ? null : publisher);
    }
}


