package multiThread.cyclicbarrier;

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
        for (int i = 0; i < 4; i++) {
            int j = i;
            new Thread(() -> {
                try {
                    int start = (int) System.currentTimeMillis() / 1000;
                    System.out.println(Thread.currentThread().getName() + ": waiting");
                    if (j == 3) {
                        try {
                            Thread.sleep(5000);
                        } catch (Exception e) {

                        }
                    }
                    cyclicBarrier.await();
                    int end = (int) System.currentTimeMillis() / 1000;
                    System.out.println(Thread.currentThread().getName() + "finish, " + "耗时" + (end - start) + "ms");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
