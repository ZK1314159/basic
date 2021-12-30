package main.java.strategy;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/28 14:55 <br>
 */
public abstract class Bird {

    FlyBehavior flyBehavior;

    WarbleBehavior warbleBehavior;

    abstract void getDescription();

    void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    void setWarbleBehavior(WarbleBehavior warbleBehavior) {
        this.warbleBehavior = warbleBehavior;
    }
}
