package main.java.multiThread.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/19 10:47 <br>
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(10);
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "finish");
                    System.out.println(Thread.currentThread().getName() +
                            "waiting thread count: " + semaphore.getQueueLength());
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
