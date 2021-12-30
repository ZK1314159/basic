package main.java.factory.simpleFactory;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/29 16:44 <br>
 */
public class SweetPizza extends Pizza{

    public void prepare() {
        System.out.println("sweet prepare!");
    };

    public void bake() {
        System.out.println("sweet bake!");
    };

    public void cut() {
        System.out.println("sweet cut!");
    };

    public void pack() {
        System.out.println("sweet pack!");
    };
}
