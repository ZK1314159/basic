package multiThread.test.create;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/4 15:13 <br>
 */
public class ImplementsRunnable implements Runnable {

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10; i++) {

            System.out.println(name + ": " + i);
        }
        if ("Test".equals(name)) {
            throw new RuntimeException();
        }
        try {
            Thread.sleep(60000);
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new ImplementsRunnable();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable, "Test");
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
