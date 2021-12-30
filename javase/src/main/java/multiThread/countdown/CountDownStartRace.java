package main.java.multiThread.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/19 10:24 <br>
 */
public class CountDownStartRace {

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    System.out.println("race: " + Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println("start race: " + Thread.currentThread().getName());
        countDownLatch.countDown();
    }
}
