package factory.factory;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/29 16:44 <br>
 */
public class NewYorkSweetPizza extends Pizza{

    public void prepare() {
        System.out.println("NewYork sweet prepare!");
    };

    public void bake() {
        System.out.println("NewYork sweet bake!");
    };

    public void cut() {
        System.out.println("NewYork sweet cut!");
    };

    public void pack() {
        System.out.println("NewYork sweet pack!");
    };
}
