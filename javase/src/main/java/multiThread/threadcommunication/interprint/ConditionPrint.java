package main.java.multiThread.threadcommunication.interprint;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/21 10:41 <br>
 */
public class ConditionPrint {

    private static boolean letAWork = true;

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        new Thread(() -> {
            reentrantLock.lock();
            try {
               for (int i = 1; i <= 100; i += 2) {
                   if (!letAWork) {
                       if (i < 100) {
                           condition.await();
                       } else {
                           break;
                       }
                   }
                   System.out.println(Thread.currentThread().getName() + ": " + i);
                   letAWork = false;
                   condition.signal();
               }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }, "A").start();

        new Thread(() -> {
            reentrantLock.lock();
            try {
                for (int i = 2; i <= 100; i += 2) {
                    if (letAWork) {
                        condition.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    letAWork = true;
                    condition.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }, "B").start();
    }

}
