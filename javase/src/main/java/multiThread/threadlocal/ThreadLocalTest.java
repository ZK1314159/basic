package main.java.multiThread.threadlocal;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/16 15:48 <br>
 */
public class ThreadLocalTest {

    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public void setThreadLocal(Integer value) {
        threadLocal.set(value);
    }

    public Integer getThreadLocal() {
        return threadLocal.get();
    }

    public static void main(String[] args) {

        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        new Thread(() -> {
            threadLocalTest.setThreadLocal(123);
            System.out.println(Thread.currentThread().getName() + ": " +
                    threadLocalTest.getThreadLocal());
        }).start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": " +
                    threadLocalTest.getThreadLocal());
        }).start();
    }

}
