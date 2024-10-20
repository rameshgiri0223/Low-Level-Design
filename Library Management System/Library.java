import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<Reck> recks;
    private List<User> users;

    // Constructor to initialize the library with a number of racks
    public Library(int numberOfRacks) {
        books = new ArrayList<>();
        recks = new ArrayList<>();
        users = new ArrayList<>();

        // Initialize racks
        for (int i = 1; i <= numberOfRacks; i++) {
            recks.add(new Reck(i));
        }
    }

    // Add a book to the library and place it on the first available rack
    public void addBook(Book book) {
        books.add(book);
        
        // Try to find an available rack and place book copies there
        for (Reck reck : recks) {
            if (reck.isEmpty()) {
                // Create a book copy and place it on the first available rack
                BookCopy bookCopy = new BookCopy(book.getBookId(), book, reck.getReckNumber(), null, false);
                reck.placeBookCopy(bookCopy);
                System.out.println("Book '" + book.getTitle() + "' added to reck " + reck.getReckNumber());
                return;
            }
        }
        System.out.println("No available racks to place the new book.");
    }

    // Remove a specific book copy by its ID
    public void removeBookCopy(int bookCopyId) {
        for (Reck rack : recks) {
            BookCopy bookCopy = rack.getBookCopy();
            if (bookCopy != null && bookCopy.getBookCopyId() == bookCopyId) {
                // Remove the book copy from the rack
                rack.removeBookCopy();
                System.out.println("Removed book copy " + bookCopyId + " from reck " + rack.getReckNumber());
                return;
            }
        }
        System.out.println("Book copy not found.");
    }

    // Borrow a book for a user
    public void borrowBook(int bookId, int userId) {
        Book book = books.stream().filter(b -> b.getBookId() == bookId).findFirst().orElse(null);

        if (book != null) {
            // Look for the first available copy of the book in the racks
            for (Reck rack : recks) {
                BookCopy bookCopy = rack.getBookCopy();
                if (bookCopy != null && bookCopy.getBook().getBookId() == bookId && bookCopy.isAvailable()) {
                    User user = users.stream().filter(u -> u.getUserId() == userId).findFirst().orElse(null);
                    
                    if (user != null && user.borrowBookCopy(bookCopy)) {
                        System.out.println(user.getName() + " borrowed " + bookCopy);
                        return;
                    } else {
                        System.out.println("User cannot borrow more than 5 books or the book is already borrowed.");
                        return;
                    }
                }
            }
        }
        System.out.println("No available copy of the book with ID " + bookId + " for borrowing.");
    }

    // Return a borrowed book copy to the library
    public void returnBook(int bookCopyId, int userId) {
        for (Reck reck : recks) {
            BookCopy bookCopy = reck.getBookCopy();
            if (bookCopy != null && bookCopy.getBookCopyId() == bookCopyId) {
                User user = users.stream().filter(u -> u.getUserId() == userId).findFirst().orElse(null);
                
                if (user != null) {
                    // Return the book to the library and update the user's borrowed books
                    user.returnBookCopy(bookCopy);
                    reck.placeBookCopy(bookCopy);
                    System.out.println(user.getName() + " returned " + bookCopy);
                    return;
                }
            }
        }
        System.out.println("Book copy not found or user mismatch.");
    }

    // Search books by title, author, or publisher
    public void searchBooks(String title, String author, String publisher) {
        List<Book> searchResults = books.stream()
            .filter(b -> (title == null || b.getTitle().contains(title)) &&
                         (author == null || b.getAuthors().contains(author)) &&
                         (publisher == null || b.getPublisher().contains(publisher)))
            .collect(Collectors.toList());

        if (searchResults.isEmpty()) {
            System.out.println("No books found matching the criteria.");
        } else {
            System.out.println("Found the following books:");
            for (Book book : searchResults) {
                System.out.println(book);
            }
        }
    }

    // Add a user to the library
    public void addUser(User user) {
        users.add(user);
    }

    public void borrowBook(int bookId, int userId, LocalDate dueDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrowBook'");
    }
}
