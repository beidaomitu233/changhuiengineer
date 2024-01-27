package thread;

public class Synchronized01 {
}
 class TicketRunnable implements Runnable {
    private static int totalTickets = 100; // 共享的票数
    private final int windowId; // 窗口号
     private boolean isSellout=true;
    public TicketRunnable(int windowId) {
        this.windowId = windowId;
    }

    // 将售票逻辑封装到单独的方法中
    private synchronized void sellTicket() {
        if (totalTickets > 0) {
            System.out.println(Thread.currentThread().getName() + " in window " + windowId + " sold ticket: " + (--totalTickets));
        } else {
            isSellout=false;
            System.out.println(Thread.currentThread().getName() + " in window " + windowId + " cannot sell more tickets, all sold out!");
        }
    }

    @Override
    public void run() {
        while (isSellout) {
            sellTicket();
            // 可以添加适当的暂停，模拟真实的售票过程
            try {
                Thread.sleep(100); // 暂停100毫秒
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public static void main(String[] args) {
        // 创建3个线程，每个线程对应一个TicketRunnable实例
        for (int i = 1; i <= 3; i++) {
            Thread thread = new Thread(new TicketRunnable(i), "Window " + i);
            thread.start();
        }
    }
}
