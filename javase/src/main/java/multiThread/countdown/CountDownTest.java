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
        for (int i = 0; i < 3; i++) {
            int k = i;
            Thread j = new Thread(() -> {
                System.out.println("subThread: " + Thread.currentThread().getName() + "start");
                int start = (int) System.currentTimeMillis() / 1000;
                if (k == 2) {
                    try {
                        Thread.sleep(5000);
                    } catch (Exception e) {

                    }
                }
                countDownLatch.countDown();
                int end = (int) System.currentTimeMillis() / 1000;
                System.out.println("subThread: " + Thread.currentThread().getName() + "finish" + "耗时" +
                        (end - start) + "ms");
            });
            j.start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "finish");
    }
}
