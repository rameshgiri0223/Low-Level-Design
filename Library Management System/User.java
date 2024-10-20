
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private int userId;
    private String name;
    private List<BookCopy> borrowedBooks;

    public User(int userId, String name){
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getUserId(){
        return userId;
    }

    public String getName(){
        return name;
    }

    public List<BookCopy> getBorrowedBooks(){
        return borrowedBooks;
    }

    public boolean borrowBookCopy(BookCopy bookCopy){
        if(borrowedBook.size() < 5 && bookCopy.isAvailable()){
            borrowedBooks.add(bookCopy);
            bookCopy.borrowBook(new Date());
            return true;
        } else {
            return false;
        }
    }

    public void returnBookCopy(BookCopy bookCopy){
        borrowedBooks.remove(bookCopy);
        bookCopy.returnBook();
    }

    @Override
    public String toString(){
        return "User ID: " + userId + ", Name: " + name;
    }
}
