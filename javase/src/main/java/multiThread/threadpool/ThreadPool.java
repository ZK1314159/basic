package multiThread.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/20 21:24 <br>
 */
public class ThreadPool {

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(5, 10, 100, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10),
                        new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        System.out.println(threadPoolExecutor.getPoolSize());
        Thread thread = new Thread(() -> {
            try {
//                System.out.println(Thread.currentThread().getName() + " is running...");
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName() + " finish");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        for (int i = 0; i < 56; i++) {
            threadPoolExecutor.submit(thread);
        }
        System.out.println(Thread.currentThread().getName() + " do work");
        try {
            Thread.sleep(20);
        } catch (Exception e) {
        }
        System.out.println(threadPoolExecutor.getPoolSize());
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        System.out.println(threadPoolExecutor.getPoolSize());
        threadPoolExecutor.shutdown();
    }

}
