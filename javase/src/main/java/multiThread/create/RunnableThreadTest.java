package main.java.multiThread.create;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/5/2 23:39 <br>
 */
public class RunnableThreadTest implements Runnable {
    int i ;

    @Override
    public void run() {
        i++;
        System.out.println(Thread.currentThread().getName() + ": " + i);
    }

    public static void main(String[] args) {
        RunnableThreadTest rt = new RunnableThreadTest();
        new Thread(rt, "thread1").start();
        //new Thread(rt, "thread2").start();
    }
}
