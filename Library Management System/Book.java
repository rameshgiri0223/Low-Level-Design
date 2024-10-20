public class Book {
    private int bookId;
    private String title;
    private String authors;
    private String publisher;

    public Book(int bookId, String title, String authors, String publisher){
        this.bookId = bookId;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
    }

    public int getBookId(){
        return bookId;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthors(){
        return authors;
    }

    public String getPublisher(){
        return publisher;
    }

    public String toString(){
        return "Book ID: " + bookId + ", Title: " + title + ", Authors: " + authors + ", Publisher: " + publisher;
    }
}
