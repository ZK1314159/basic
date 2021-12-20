package multiThread.threadcommunication.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/19 14:13 <br>
 */
public class ExchangerTest {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "start");
                String A = "A test kdjfjksd";
                String receive = exchanger.exchange(A);
                System.out.println(Thread.currentThread().getName() +
                        "received message:" + receive);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "start");
                String B = "B test ejrekl";
                String receive = exchanger.exchange(B);
                System.out.println(Thread.currentThread().getName() +
                        "received message:" + receive);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "start");
                String c = "c test dlfjdjkfkl";
                String receive = exchanger.exchange(c);
                System.out.println(Thread.currentThread().getName() +
                        "received message:" + receive);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
//        new Thread(() -> {
//            try {
//                System.out.println(Thread.currentThread().getName() + "start");
//                String d = "d test dgdgbdgg";
//                String receive = exchanger.exchange(d);
//                System.out.println(Thread.currentThread().getName() +
//                        "received message:" + receive);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }).start();
        System.out.println(Thread.currentThread().getName() + "end");
    }
}
