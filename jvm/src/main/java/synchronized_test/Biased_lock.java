package synchronized_test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.openjdk.jol.info.ClassLayout;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/6/25 14:22 <br>
 */

public class Biased_lock {

    private int i = 2;

    public static void main(String[] args) throws Exception {

        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(3, 3, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>(5),
                        new ThreadPoolExecutor.CallerRunsPolicy());
        //JKD8延迟4S开启偏向锁
        //可偏向 101
        final Object monitor = new Object();
        System.out.println("初始对象布局：\n" + ClassLayout.parseInstance(monitor).toPrintable());
        //偏向锁
        for (int i = 0; i < 2; i++) {
            threadPoolExecutor.submit(new Thread_Test(monitor));
        }
        threadPoolExecutor.shutdown();
//        Thread thread2 = new Thread(()-> {
//            synchronized (monitor) {
//                System.out.println("第二次对象加锁后的布局：");
//                System.out.println("线程id：" + Long.toHexString(Thread.currentThread().getId()));
//                System.out.println("第二次" + ClassLayout.parseInstance(monitor).toPrintable());
//            }
//        });
//        thread2.start();
//        thread2.join();
//        System.out.println("对象释放锁后的布局：\n" + ClassLayout.parseInstance(monitor).toPrintable());
//        synchronized (monitor) {
//            System.out.println("第三次对象加锁后的布局：");
//            System.out.println("线程id：" + Long.toBinaryString(Thread.currentThread().getId()));
////            System.out.println("hashcode：" + Long.toBinaryString(monitor.hashCode()));
//            System.out.println(ClassLayout.parseInstance(monitor).toPrintable());
//        }
    }
}
