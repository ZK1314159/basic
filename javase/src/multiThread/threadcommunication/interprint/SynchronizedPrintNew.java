package multiThread.threadcommunication.interprint;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/20 16:13 <br>
 */
public class SynchronizedPrintNew {

    private static boolean letAWork = true;

    public static void main(String[] args) {

        SynchronizedPrintNew synchronizedPrintNew = new SynchronizedPrintNew();

        new Thread(() -> {
            synchronized (synchronizedPrintNew) {
                for (int i = 1; i <= 100; i += 2) {
                    if (!letAWork) {
                        try {
                            if (i < 100) {
                                synchronizedPrintNew.wait();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    letAWork = false;
                    synchronizedPrintNew.notify();
                }
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (synchronizedPrintNew) {
                for (int i = 2; i <= 100; i += 2) {
                    if (letAWork) {
                        try {
                            synchronizedPrintNew.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    letAWork = true;
                    synchronizedPrintNew.notify();
                }
            }
        }, "B").start();
    }

}



