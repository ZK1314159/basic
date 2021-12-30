package main.java.multiThread.other.park;

import java.util.Timer;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/31 15:10 <br>
 */
public class ParkTest {

    public static void main(String[] args) {
        Park park = new Park();
        ParkIn parkIn = new ParkIn();
        parkIn.setPark(park);
        for (int i = 0; i < 20; i++) {
            new Thread(parkIn, "Thread " + i).start();
        }

        Timer timer = new Timer();
        ParkOut parkOut = new ParkOut();
        parkOut.setPark(park);
        timer.schedule(parkOut, 100L, 500L);
    }
}
