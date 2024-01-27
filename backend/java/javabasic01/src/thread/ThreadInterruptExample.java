package thread;

// 创建一个代表任务的Runnable接口实现类
class SleeperTask implements Runnable {
    private String name;

    public SleeperTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is going to sleep for 5 seconds...");
            // 让线程休眠5秒
            Thread.sleep(5000);
            System.out.println(name + " has woken up after sleeping.");
        } catch (InterruptedException e) {
            // 当线程被中断时，catch InterruptedException
            System.out.println(name + " was interrupted while sleeping.");
        }
    }
}

public class ThreadInterruptExample {
    public static void main(String[] args) throws InterruptedException {
        SleeperTask sleeper = new SleeperTask("Sleeping Thread");

        // 创建并启动新线程
        Thread thread = new Thread(sleeper);
        thread.start();

        // 主线程等待1秒后尝试中断子线程
        Thread.sleep(1000);
        System.out.println("Main thread is interrupting the sleeping thread...");
        // 中断休眠的线程
        thread.interrupt();
    }
}