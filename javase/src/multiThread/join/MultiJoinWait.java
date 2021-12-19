package multiThread.join;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/19 9:56 <br>
 */
public class MultiJoinWait {

    public static void main(String[] args) throws Exception {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread j = new Thread(() -> System.out.println("test: " + Thread.currentThread().getName()));
            j.start();
            threadList.add(j);
        }
        for (Thread thread : threadList) {
            thread.join();
            System.out.println("finish" + thread.getName());
        }
        System.out.println("finish" + Thread.currentThread().getName());
    }
}
