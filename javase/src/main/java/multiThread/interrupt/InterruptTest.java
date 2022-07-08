package multiThread.interrupt;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/7/8 16:58 <br>
 */
public class InterruptTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            try {
                System.out.println("start");
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedException();
                    }
                    if (System.currentTimeMillis() - start > 4000) {
                        break;
                    }
                }
                System.out.println("end");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        System.out.println("main resume");
        thread.interrupt();
    }

}
