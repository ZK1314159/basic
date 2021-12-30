package multiThread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/4 15:20 <br>
 */
public class ImplementsCallable implements Callable<Integer> {

    public Integer call() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            String name = Thread.currentThread().getName();
            sum++;
            System.out.println(name + ": " + sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        Callable<Integer> callable = new ImplementsCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask, "myfuture").start();
        try {
            Integer result = futureTask.get();
            System.out.println(result);
        } catch (Exception e) {

        }
    }

}
