package main.java.multiThread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/19 11:21 <br>
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> {
            System.out.println("all thread finish");
        });
        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + ": waiting");
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
