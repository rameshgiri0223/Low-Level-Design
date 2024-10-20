public class Reck {
    private int reckNumber;
    private BookCopy bookCopy;

    public Reck(int reckNumber){
        this.reckNumber  = reckNumber;
    }

    public int getReckNumber(){
        return reckNumber;
    }

    public boolean isEmpty(){
        return bookCopy == null;
    }

    public void placeBookCopy(BookCopy bookCopy){
        this.bookCopy = bookCopy;
    }

    public BookCopy removeBookCopy(){
        BookCopy temp = this.bookCopy;
        this.bookCopy = null;
        return temp;
    }

    public BookCopy getBookCopy(){
        return bookCopy;
    }

    public String toString(){
        return  "Reck Number: " + reckNumber + (bookCopy != null ? ", " + bookCopy.toString() : ", Empty");
    }
}
