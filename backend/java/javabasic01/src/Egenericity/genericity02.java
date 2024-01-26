package Egenericity;

import java.util.*;

public class genericity02 {
    public static void main(String[] args) {
        /*
        *
        *
        * 定义Employee类
            1)该类包含：privatel成员变量name,sal,birthday,其中birthday为MyDate类的对象：
            2)为每一个属性定义getter,,setter方法；
            3)重写toString方法输出name,sal,birthday
            4)MyDate类包含：private成员变量nonth,day,year;并为每一个属性定义getter,setter方法：
            5)创建该类的3个对像，并把这些对象放入ArrayList集合中(ArrayList需使用泛型来定义)，对集合中的元素进行排序，并遍历输出：

            排序方式：调用ArrayList的sort方法，传入Comparator对像[使用泛型，先按照name排序，如果name相同，则按生日日期的先后排序。【即：定制排序】
        *
        *
        * */

        List<Employee> list=new ArrayList<>();
        list.add(new Employee("张三",4120,new MyDate(23,2,2007)));
        list.add(new Employee("李四",4000,new MyDate(22,5,2010)));
        list.add(new Employee("张三",4520,new MyDate(22,5,1992)));
        list.add(new Employee("王五",4120,new MyDate(23,2,2003)));
        list.add(new Employee("来福",4120,new MyDate(23,2,2002)));


//           自定义排序规则
        list.sort(new Comparator<Employee>(){
            @Override
            public int compare(Employee o1, Employee o2) {
//                    使用姓名来排序，
                /**
                 *
                 *
                 * CompareTo方法已经对中文字符串进行了很好的支持，因为它使用了字符串中字符的Unicode编码来进行比较。汉字在Unicode中是按照拼音顺序排列的，
                 *
                 * **/
                return Comparator1 ( o1,  o2);
            }
            private int Comparator1(Employee o1, Employee o2) {
                int a= o1.getEmpName().compareTo(o2.getEmpName());
                if (a==0){
                    return o1.getBirthday().Comparator(o2);
                }else   return a;

            }

        });
        Iterator<Employee> iterator = list.iterator();
        while (iterator.hasNext()) {
            Employee next =  iterator.next();


            System.out.println(next);

        }
        
        


    }



}

class Employee{
    private String EmpName;
    private double salary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0 && Objects.equals(EmpName, employee.EmpName) && Objects.equals(birthday, employee.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(EmpName, salary, birthday);
    }

    private MyDate birthday;

    public Employee(String empName, double salary, MyDate birthday) {
        EmpName = empName;
        this.salary = salary;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmpName='" + EmpName + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }
}
class MyDate {
    private int day;
    private int month;

    private int year;

    @Override
    public String toString() {
        return year+"-"+ month+"-"+day;
    }

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int Comparator(Employee o2){
        if (year<o2.getBirthday().getYear()){
            return -1;
        } else if (month<o2.getBirthday().getMonth()) {
            return -1;
        }else if (day<o2.getBirthday().getDay()) {
            return -1;
        }
        return 0;
    }

}