package multiThread.threadcommunication.interprint;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/20 16:13 <br>
 */
public class SynchronizedPrint {

    public static void main(String[] args) {
        Task task = new Task();
        new Thread(task, "Task A").start();
        new Thread(task, "Task B").start();
    }

}

class Task implements Runnable {

    private int number;

    @Override
    public void run() {
        synchronized (this) {
            while (number <= 100) {
                System.out.println(Thread.currentThread().getName() + ": " + number);
                number++;
                notify();
                try {
                    if (number < 100) {
                        wait();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
