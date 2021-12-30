package main.java.factory.simpleFactory;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/29 11:28 <br>
 */
public abstract class Pizza {

    abstract void prepare();

    abstract void bake();

    abstract void cut();

    abstract void pack();
}
