package linux;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/4/6 22:02 <br>
 */
public class LinuxTest2 {

    public static void main(String[] args) {
        System.out.println("start!");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": start!");
                int start = 0;
                while (true) {
                    start++;
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": start!");
                int start = 0;
                while (true) {
                    start++;
                }
            }
        }).start();
    }

}
