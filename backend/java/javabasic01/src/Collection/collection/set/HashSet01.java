package Collection.collection.set;

import javax.xml.namespace.QName;
import java.util.*;

public class HashSet01 {

    public static void main(String[] args) {
        Set set1=new HashSet();
/**
 *
 * 1. 无序（添加和取出的顺序不一致）没有索引，取出实际上是是固定的，每次取出都是一样的结果
 *  2. 不允许重复元素，所以最多包含一个u川
 *
 * **/

        set1.add("再别康桥");
        set1.add("雨巷");
        set1.add("雨巷");
        set1.add("雨巷");
        set1.add("雨巷");
        set1.add("志摩的诗");
        set1.add(null);
        set1.add(null);

        System.out.println(set1);

        /**
         *
         *  遍历Set接口对象（指的是实现了Set接口的实例化对象）
         *  1. 使用迭代器
         *  2.使用增强for
         *
         * **/

        System.out.println("-------迭代器--------");
        Iterator iterator=set1.iterator();
        while (iterator.hasNext()) {
//            next会返回当前元素并指向下一个元素
            Object next =  iterator.next();
            System.out.println(next);
            
        }

        System.out.println("-------for循环--------");

        for (Object o : set1) {
            System.out.println(o);
        }


        System.out.println("-------添加多个内容相同的实例类对象--------");
//        添加多个内容相同的实例类对象

        Set set02=new HashSet();

        set02.add(new Dog("jzc"));
        set02.add(new Dog("jzc"));

        set02.add(new String("abc"));
        set02.add(new String("abc"));

        System.out.println(set02);

        Set haslink=new LinkedHashSet();

        haslink.add("sadsad");


    }


}
class Dog{
    public String Dname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(Dname, dog.Dname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Dname);
    }

    public String getDname() {
        return Dname;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "Dname='" + Dname + '\'' +
                '}';
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public Dog(String dname) {
        Dname = dname;
    }
}