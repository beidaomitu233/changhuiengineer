package thread;

public class Runnable01 {

    public static void main(String[] args) {

    }

}

//使用代理模式实现了创建线程并调用方法。

class ThreadExp implements Runnable{


    private Runnable target=null;

    @Override
    public void run() {
        if (target!=null){
            target.run();
        }

    }

    public ThreadExp(Runnable target){
        this.target=target;
    }

    void start(){
        //这一步才是最重要的，调用start0来创建线程
        start0();
    }

    void start0(){
//        创建好后在执行重写后的run方法
        run();
    }
}

