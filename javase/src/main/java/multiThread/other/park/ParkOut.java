package main.java.multiThread.other.park;

import java.util.Date;
import java.util.TimerTask;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/31 15:08 <br>
 */
public class ParkOut extends TimerTask {

    Park park;

    void setPark(Park park) {
        this.park = park;
    }

    public void run() {
        synchronized (park) {
            for (int i = 0; i < park.position.length; i++) {
                if (!park.position[i].hasCar
                        && new Date().getTime() - park.position[i].now > park.position[i].parkTime) {
                    park.position[i].hasCar = true;
                    System.out.println("I drive away a car! " + System.currentTimeMillis());
                    //notifyAll();
                    return;
                }
            }
            System.out.println("There is no car can drive away! " + System.currentTimeMillis());
        }
    }
}
