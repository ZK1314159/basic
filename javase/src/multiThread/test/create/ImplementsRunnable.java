package multiThread.test.create;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/4 15:13 <br>
 */
public class ImplementsRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            String name = Thread.currentThread().getName();
            System.out.println(name + ": " + i);
        }
        try {
            Thread.sleep(60000);
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new ImplementsRunnable();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String name = Thread.currentThread().getName();
                System.out.println(name + ": " + i);
            }
            try {
                Thread.sleep(60000);
            } catch (Exception e) {
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
