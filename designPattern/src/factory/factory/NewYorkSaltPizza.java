package factory.factory;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/29 16:44 <br>
 */
public class NewYorkSaltPizza extends Pizza {

    public void prepare() {
        System.out.println("NewYork salt prepare!");
    };

    public void bake() {
        System.out.println("NewYork salt bake!");
    };

    public void cut() {
        System.out.println("NewYork salt cut!");
    };

    public void pack() {
        System.out.println("NewYork salt pack!");
    };
}
