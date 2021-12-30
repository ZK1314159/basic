package multiThread.threadcommunication;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/20 20:33 <br>
 */
public class BlockingQueueTest {

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    blockingQueue.put(i);
                    System.out.println(Thread.currentThread().getName() + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "Producer A").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    blockingQueue.put(i);
                    System.out.println(Thread.currentThread().getName() + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Producer B").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    Integer integer = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName() + integer);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Consumer C").start();
    }
}
