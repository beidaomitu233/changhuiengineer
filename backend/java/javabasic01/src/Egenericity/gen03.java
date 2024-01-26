package Egenericity;

public class gen03 implements shape<String> {
    public static void main(String[] args) {


        Animal.printArray(new Integer[]{123, 3, 123, 5, 13});

    }


    @Override
    public void A(String o) {

    }
}

//  自定义泛型,Animal类后面有泛型就是自定义泛型
/**
 * 2.E T Q 都是泛型的标识符，一般是单个的大写字母
 * 3.泛型的标识符可以有多个
 * 4.普通成员可以使用泛型（属性，方法）
 * 5.使用泛型的数组不能初始化，因为没有确定的类型
 * 6.静态方法和属性不能使用泛型，因为静态是加载类的时候就加载了，而具体的类型是创建对象才确定。
 * **/
class Animal<E,T,Q>{

    String AnimalName;

    E e;
    T t;
    Q q;

    public Animal(String animalName, E e, T t, Q q) {
        AnimalName = animalName;
        this.e = e;
        this.t = t;
        this.q = q;
    }
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }


}

interface shape<T>{

    void A(T t);

}
