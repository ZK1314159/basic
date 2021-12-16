package multiThread.test.example.park;


/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/31 15:10 <br>
 */
public class Park {

    Car[] position = new Car[4];

    {
        for (int i = 0; i < position.length; i++) {
            position[i] = new Car();
            position[i].hasCar = true;
        }
    }
}
