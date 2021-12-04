package multiThread.test.create;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/4 11:55 <br>
 */
public class ExtendsThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            String name = currentThread().getName();
            System.out.println(name + ": " + i);
        }
        try {
            Thread.sleep(60000);
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        System.out.println("currentThread: " + main.getName());
        Thread thread1 = new ExtendsThread();
        thread1.start();
        Thread thread2 = new ExtendsThread();
        thread2.start();
        try {
            Thread.sleep(60000);
        } catch (Exception e) {
        }
    }

}
