package thread;

public class SleepingThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Going to sleep for 2 seconds...");
            Thread.sleep(2000); // 线程休眠2秒
            System.out.println("Thread has woken up.");
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted while sleeping.");
            Thread.currentThread().interrupt(); // 重新设置中断标志
        }
    }

    public static void main(String[] args) {
        SleepingThread sleeper = new SleepingThread();
        sleeper.start();
    }
}
