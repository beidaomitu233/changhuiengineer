package thread;

public class runnable02 {
    public static void main(String[] args) throws InterruptedException {
        r2 r2 = new r2();
        Thread thread = new Thread(r2);
//      调用start和会开启一个新的线程去执行run放法
        thread.start();

//      后续代码还是由main线程执行
//       所以这里的代码和run里面的代码同步执行

        //在某个条件后就设置终止条件
        Thread.sleep(10);

        r2.setLoop(false);
    }
}


class  r2 implements  Runnable{
    private  boolean loop=true;
    @Override
    public void run() {
        while (loop){

            System.out.println(Thread.currentThread().getName()+"子线程正在运行");
        }
    }
    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}



