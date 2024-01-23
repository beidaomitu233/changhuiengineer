package Abnormal;

import java.util.Scanner;

public class TryCatch {
//    案例：让用户输入一个整数，如果不是就一直循环。

    public static void main(String[] args) {
        System.out.println("年龄是："+GetUserAge());
    }

public static int GetUserAge(){
    Scanner sc=new Scanner(System.in);
    //调用功能
    System.out.println("请输入年龄");
    //Int表示接的是整数
    int Age = 0;
    try {
         Age = sc.nextInt();
         return Age; // 在这里返回年龄
    } catch (Exception e) {
        System.out.println("请输入整数哦");
        GetUserAge();
    }finally {
        sc.close(); // 关闭资源
    }

    //默认返回0
    return Age;
}


}
