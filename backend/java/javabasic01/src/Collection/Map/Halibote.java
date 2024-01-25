package Collection.Map;

public class Halibote {
    public String BookName;

    public String getBookName() {
        return BookName;
    }

    @Override
    public String toString() {
        return "Halibote{" +
                "BookName='" + BookName + '\'' +
                '}';
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public Halibote(String bookName) {
        BookName = bookName;
    }
}
