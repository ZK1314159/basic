package multiThread.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/19 10:24 <br>
 */
public class CountDownTest {

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 5; i++) {
            Thread j = new Thread(() -> {
                System.out.println("subThread: " + Thread.currentThread().getName());
                countDownLatch.countDown();
            });
            j.start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "finish");
    }
}
