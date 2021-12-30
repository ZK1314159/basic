package main.java.strategy;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/28 15:09 <br>
 */
public class BirdTest {

    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        FlyBehavior sparrowFly = new SparrowFly();
        sparrow.setFlyBehavior(sparrowFly);
        WarbleBehavior sparrowWarble = new SparrowWarble();
        sparrow.setWarbleBehavior(sparrowWarble);
        sparrow.getDescription();
        sparrow.flyBehavior.fly();
        sparrow.warbleBehavior.warble();
    }
}
