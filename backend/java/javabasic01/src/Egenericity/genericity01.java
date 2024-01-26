package Egenericity;

public class genericity01 {

    public static void main(String[] args) {

        Book<String> book1 = new Book<String>("哈利波特");
        System.out.println(book1.BookName);
        book1.getclass();

        /**
         * 指定为String类型后就会变成这样。编译时类型就确定为所指定的String
         *
         *class Book<String>{
         *     String BookName;
         *
         *     public Book(String bookName) {
         *         BookName = bookName;
         *     }
         *
         *     public String getBookName() {
         *         return BookName;
         *     }
         *
         *     public void setBookName(String bookName) {
         *         BookName = bookName;
         *     }
         * }
         *
         *
         *
         * **/




    }
    


}

// E表示泛型，传递什么类型就会替换成什么类型
class Book<E>{
    E BookName;

    public Book(E bookName) {
        BookName = bookName;
    }

    public E getBookName() {
        return BookName;
    }

    public void setBookName(E bookName) {
        BookName = bookName;
    }

    public void getclass(){
        System.out.println(BookName.getClass());
    }
}
