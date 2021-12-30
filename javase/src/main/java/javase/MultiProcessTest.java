package javase;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/6/15 19:31 <br>
 */
public class MultiProcessTest implements Runnable {
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        new Thread(new MultiProcessTest(), "Thread1").start();
        new Thread(new MultiProcessTest(), "Thread2").start();
        new Thread(new MultiProcessTest(), "Thread3").start();
    }
}
