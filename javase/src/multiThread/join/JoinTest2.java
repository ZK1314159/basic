package multiThread.join;

/**
 * jion()会释放将要加入的Therad本身这把锁，可以正常运行
 * <br>
 * CreateDate：2021/12/4 17:17 <br>
 */
public class JoinTest2 implements Runnable {

    private final Object object;

    public JoinTest2(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        System.out.println(Thread.currentThread().getName() + ": 开始执行" );
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                String name = Thread.currentThread().getName();
                System.out.println(name + ": " + i);
            }
        }
    }

    public static void main(String[] args) {
        Object object = new Object();
        Runnable runnable = new JoinTest2(object);
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println(Thread.currentThread().getName() + ": 开始执行" );
        synchronized (thread) {
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
