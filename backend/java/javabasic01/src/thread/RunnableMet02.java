package thread;

public class RunnableMet02 {
    public static void main(String[] args) throws InterruptedException {
//        join方法和yield方法
   /**
    * join方法是直接插入执行队列优先执行，执行完后才可以回来执行其他的任务，
    * yield方法是让出一部分资源，如果资源充足就不会让。
    *
    * **/

        threadrun threadrun = new threadrun();
        Thread thread = new Thread(threadrun);
//      创建线程并执行代码
        thread.start();
//        给线程重命名
        thread.setName("小龙");
//       让子线程先执行，完成后再回来执行自己的
     //   thread.join();
        Thread.yield();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"跑了第"+i);
        }

    }
}
class threadrun implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"跑了第"+i);
        }

    }
}