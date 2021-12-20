package multiThread;

import multiThread.other.Singleton;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

class ThreadTest {
    public static void main(String[] args) throws Exception {

        AtomicReference<Singleton> atomicReference = new AtomicReference<>();
//        atomicReference.compareAndSet()
        AtomicInteger atomicInteger = new AtomicInteger();
//        atomicInteger.compareAndSet()

        new Thread("新线程1") {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(getName() + " " + i);
                }
            }
        }.start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }, "新线程2").start();

        System.out.println("主线程");

        FutureTask<Integer> task = new FutureTask<>(() -> {
            int j = 0;
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            return j;
        });
        new Thread(task, "新线程3").start();
    }
}