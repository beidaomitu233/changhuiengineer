package Collection.homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class work02 {

    public static void main(String[] args) {

        /**
         *
         * 使用ArrayList完成对对像Car{name,price}的各种操作
         * 1.add:添加单个元素
         * 2.remove:删除指定元素
         * 3.contains:查找元素是否存在
         * 4.size获取元素个数
         * 5.isEmpty:判断是否为空
         * 6.clear:清空
         * 7.addAll:添加多个元素
         * 8.containsAll:查找多个元素是否都存在
         * 9.removeAll:删除多个元素
         * 使用增强for和迭代器来遍历所有的car,需要重写Car的toString.方法
         *  Carcar=new Car("宝马"，400000)i
         * Car car2=new Car("宾利"，5000000)：
         * **/

    List<Car> car=new ArrayList();
    car.add(new Car("宝马",400000));
    car.add(new Car("宾利",5000000));
        car.add(new Car("吉利",1700000));
        car.add(new Car("极星",1000000));
        car.add(new Car("银河",200000));
        car.add(new Car("领克",3000000));

        System.out.println("---------增强for循环---------");
        for (Car car1 : car) {
            System.out.println(car1);
            
        }

        System.out.println("---------迭代器---------");
        Iterator iterator=car.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }

        System.out.println("---------remove---------");

        System.out.println(car.remove(1));

        System.out.println("---------contains---------");
        System.out.println(car.contains("吉利"));


    }

}
class Car {
    public String CarName;

    public Car(String carName, double carPrice) {
        CarName = carName;
        CarPrice = carPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(CarPrice, car.CarPrice) == 0 && Objects.equals(CarName, car.CarName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CarName, CarPrice);
    }

    @Override
    public String toString() {
        return "Car{" +
                "CarName='" + CarName + '\'' +
                ", CarPrice=" + CarPrice +
                '}';
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public double getCarPrice() {
        return CarPrice;
    }

    public void setCarPrice(double carPrice) {
        CarPrice = carPrice;
    }

    public double CarPrice;
}