package thread;

public class Thread01 {

    public static void main(String[] args) {


//        创建Cat对象，可以当作线程使用 ,相当于新建一个子线程
        Cat cat = new Cat();
        cat.start();

        int times=0;
//        main方法中的主线程不受影响，可以执行其他任务
        while (times<5){
            times++;
            System.out.println("主线程"+times+Thread.currentThread().getName());


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

class Cat extends Thread{

    int times=0;
    @Override
    public void run() {
        super.run();

        while (times<5){
            times++;
            System.out.println("喵喵喵"+times+Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
