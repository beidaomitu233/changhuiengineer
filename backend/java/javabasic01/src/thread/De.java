package thread;

public class De {
    public static void main(String[] args) throws InterruptedException {
        shouhu shouhu = new shouhu();
        Thread thread = new Thread(shouhu);

//        设置为守护线程
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            System.out.println("唱跳rap中....");

        }

        System.out.println("凉了");

    }

}

class shouhu implements Runnable{

    @Override
    public void run() {

        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("永远守护最好的哥哥");
        }

    }
}