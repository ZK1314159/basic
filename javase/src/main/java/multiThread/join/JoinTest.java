package main.java.multiThread.join;

/**
 * jion()不会释放普通锁，可能会导致死锁
 * <br>
 * CreateDate：2021/12/4 17:17 <br>
 */
public class JoinTest implements Runnable {

    private final Object object;

    public JoinTest(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        System.out.println(Thread.currentThread().getName() + ": 开始执行" );
        synchronized (object) {
            for (int i = 0; i < 10; i++) {
                String name = Thread.currentThread().getName();
                System.out.println(name + ": " + i);
            }
        }
    }

    public static void main(String[] args) {
        Object object = new Object();
        Runnable runnable = new JoinTest(object);
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println(Thread.currentThread().getName() + ": 开始执行" );
        synchronized (object) {
            try {
                thread.join();
            } catch (Exception e) {

            }
            for (int i = 0; i < 10; i++) {
                String name = Thread.currentThread().getName();
                System.out.println(name + ": " + i);
            }
        }
    }

}
