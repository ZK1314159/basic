package multiThread.threadcommunication.interprint;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/20 15:18 <br>
 */
public class CasPrint {

    public static void main(String[] args) {
        AtomicInteger flag = new AtomicInteger();
        new Thread(() -> {
            for (int i = 0; i < 100; i += 2) {
                for (;;) {
                    if (flag.compareAndSet(0, 1)) {
                        System.out.println(Thread.currentThread().getName() + ": " + (i + 1));
                        break;
                    }
                }
                for (;;) {
                    if (flag.compareAndSet(1, 2)) {
                        break;
                    }
                }
            }
        }, "Thread A").start();
        new Thread(() -> {
            for (int i = 1; i < 100; i += 2) {
                for (;;) {
                    if (flag.compareAndSet(2 , 3)) {
                        System.out.println(Thread.currentThread().getName() + ": " + ( i + 1));
                        break;
                    }
                }
                for (;;) {
                    if (flag.compareAndSet(3 , 0)) {
                        break;
                    }
                }
            }
        }, "Thread B").start();
    }
}
