package thread;

public class Thread02 {
    public static void main(String[] args) {

        Dog dog = new Dog();
//      底层使用了代理模式，实现了这个功能。
//        所以需要把Runnable接口对象传入，让Thread创建线程并代理调run放法。
        Thread thread = new Thread(dog);
        thread.start();


    }
}

class Dog implements Runnable{
    int times=0;
    @Override
    public void run() {
        while (times<5){
            times++;
            System.out.println("汪汪汪"+times+Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
