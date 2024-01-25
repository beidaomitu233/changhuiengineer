package Collection.collection.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
// Book 类定义
class Book {
    private String name;
    private double price;
    // Book 类的构造函数
    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }
    // 获取书籍名称
    public String getName() {
        return name;
    }
    // 设置书籍名称
    public void setName(String name) {
        this.name = name;
    }
    // 获取书籍价格
    public double getPrice() {
        return price;
    }
    // 设置书籍价格
    public void setPrice(double price) {
        this.price = price;
    }
    // toString 方法，用于打印书籍信息
    @Override
    public String toString() {
        return "书名:"+name+",价格:"+price;
    }
}
// 主类
public class ArrayList02 {
    public static void main(String[] args) {
        // 创建一个ArrayList来存储Book对象
        ArrayList<Book> books = new ArrayList<>();
        // 添加一些Book对象到ArrayList中
        books.add(new Book("Book1", 9.99));
        books.add(new Book("Book2", 223.99));
        books.add(new Book("Book3", 29.99));
        books.add(new Book("Book4", 91.99));
        books.add(new Book("Book5", 123.99));
        books.add(new Book("Book6", 229.99));
        // 打印原始的书籍列表
        System.out.println("Original Books: " + books);
        // 使用Collections.sort()方法对书籍列表按价格进行排序
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                // 按价格升序排序
                return Double.compare(b1.getPrice(), b2.getPrice());
            }
        });
        // 打印排序后的书籍列表
        System.out.println("Sorted Books by Price: " + books);
    }
}
