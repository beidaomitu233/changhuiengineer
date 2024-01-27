package thread;

public class RunnabnleMet {
    public static void main(String[] args) {
        Intera intera = new Intera();
        Thread thread = new Thread(intera);
//      创建线程并执行代码
        thread.start();
//        给线程重命名
        thread.setName("小龙");
//      中断休眠，中断后会抛出 InterruptedException异常，接收后可以执行其他任务，可以处理或者不处理。
        thread.interrupt();

    }

}

class Intera implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"跑了第"+i);
            if (i==5){
                try {
                    System.out.println("想休息10秒钟");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("休息被打断");
                }
            }

        }

    }
}
