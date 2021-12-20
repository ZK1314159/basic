package multiThread.threadcommunication.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/20 14:17 <br>
 */
public class InterPrint {

    public Integer id;

    public static void main(String[] args) {
        Exchanger<Boolean> exchanger = new Exchanger<>();
        InterPrint interPrint = new InterPrint();
        new Thread(() -> {
            for (int i = 0; i < 100; i += 2) {
                System.out.println(Thread.currentThread().getName() + ": " + (i + 1));
//                try {
//                    exchanger.exchange(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }
        }, "Thread A").start();
        new Thread(() -> {
            for (int i = 1; i < 100; i += 2) {
                System.out.println(Thread.currentThread().getName() + ": " + (i + 1));
//                try {
//                    exchanger.exchange(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }
        }, "Thread B").start();
    }
}
