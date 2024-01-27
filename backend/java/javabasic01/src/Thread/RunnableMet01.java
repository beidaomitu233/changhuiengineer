package thread;

public class RunnableMet01 {

//    常见线程方法的使用

    public static void main(String[] args) {
        T1 t1 = new T1();



    }




}


class T1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"线程,跑了"+i+"圈");

        }
    }
}
