package main.java.multiThread.threadcommunication.interprint;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/20 15:59 <br>
 */
public class VolatilePrint {

    private static volatile int flag = 0;

    public static void main(String[] args) {

        new Thread(() -> {
            int number = 1;
            while (number <= 99) {
                if (VolatilePrint.flag == 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number += 2;
                    VolatilePrint.flag = 1;
                }
            }
        }).start();

        new Thread(() -> {
            int number = 2;
            while (number <= 100) {
                if (VolatilePrint.flag == 1) {
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number += 2;
                    VolatilePrint.flag = 0;
                }
            }
        }).start();
    }

}


