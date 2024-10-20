import java.util.Date;

public class BookCopy {
    private int bookCopyId;
    private Book book;
    private int reckNumber;
    private Date dueDate;
    private boolean isAvailable;

    public BookCopy(int bookCopyId, Book book, int reckNumber, Date dueDate, boolean isAvailable){
        this.bookCopyId = bookCopyId;
        this.book = book;
        this.reckNumber = reckNumber;
        this.dueDate  = dueDate;
        this.isAvailable = true;
    }

    public int getBookCopyId(){
        return bookCopyId;
    }

    public int getReckNumber(){
        return reckNumber;
    }

    public Date getDueDate(){
        return dueDate;
    }

    public boolean isAvailable(){
        return  isAvailable;
    }

    public void borrowBook(Date dueDate){
        if(isAvailable){
            this.dueDate = dueDate;
            this.isAvailable = false;
        }
    }

    public void returnBook(){
        this.dueDate = null;
        this.isAvailable = true;
    }

    public Book getBook(){
        return book;
    }

    public String toString(){
        return "BookCopy ID: " + bookCopyId + ", Book: " + book + ", Reck Number: " + reckNumber + ", Available: " + isAvailable;
    }
}
