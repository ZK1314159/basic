package multiThread;

import java.util.concurrent.*;

class ThreadTest {
    public static void main(String[] args) throws Exception {
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