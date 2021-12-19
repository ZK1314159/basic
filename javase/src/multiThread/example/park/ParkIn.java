package multiThread.example.park;

import java.util.Date;
import java.util.Random;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/31 15:08 <br>
 */
public class ParkIn implements Runnable {

    Park park;

    int pos;

    void setPark(Park park) {
        this.park = park;
    }

    public void run() {
        synchronized (park) {
            for (int i = 0; i < park.position.length; i++) {
                if (park.position[i].hasCar) {
                    park.position[i].hasCar = false;
                    park.position[i].now = new Date().getTime();
                    double tmp = new Random().nextDouble();
                    long parkTime = (long) (tmp*3000);
                    park.position[i].parkTime = parkTime;
                    try {
                        Thread.sleep(1);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " : I park a car! " + System.currentTimeMillis());
                    return;
                }
            }
            System.out.println(Thread.currentThread().getName() + " : I get resume by myself! " + System.currentTimeMillis());
//            try {
//                wait(5000L);
//            }
//            catch (InterruptedException e) {
//                System.out.println(Thread.currentThread().getName() + " : I am waiting！");
//                //e.printStackTrace();
//            }
        }
    }
}
