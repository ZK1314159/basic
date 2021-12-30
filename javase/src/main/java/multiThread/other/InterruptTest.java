package main.java.multiThread.other;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/14 17:49 <br>
 */
public class InterruptTest {

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            long start = System.currentTimeMillis();
            while (true) {
                long end = System.currentTimeMillis();
                if (end - start > 1000) {
                    break;
                }
            }
            System.out.println("start");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("end");
        });
        thread.start();
        Thread.sleep(500);
//        LockSupport.unpark(thread);
        thread.interrupt();
        System.out.println("main end");
    }
}
