package synchronized_test;

import org.openjdk.jol.info.ClassLayout;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/6/25 17:20 <br>
 */
public class Thread_Test implements Runnable {

    private Object monitor;

    public Thread_Test(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
            String id = Long.toBinaryString(Thread.currentThread().getId());
            System.out.println(id + "对象加锁后的布局：" + ClassLayout.parseInstance(monitor).toPrintable());
        }
    }

}
