package factory.factory;

import factory.factory.Pizza;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/29 16:44 <br>
 */
public class BeijingSweetPizza extends Pizza{

    public void prepare() {
        System.out.println("Beijing sweet prepare!");
    };

    public void bake() {
        System.out.println("Beijing sweet bake!");
    };

    public void cut() {
        System.out.println("Beijing sweet cut!");
    };

    public void pack() {
        System.out.println("Beijing sweet pack!");
    };
}
