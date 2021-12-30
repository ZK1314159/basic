package factory.simpleFactory;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/29 16:44 <br>
 */
public class SaltPizza extends Pizza {

    public void prepare() {
        System.out.println("salt prepare!");
    };

    public void bake() {
        System.out.println("salt bake!");
    };

    public void cut() {
        System.out.println("salt cut!");
    };

    public void pack() {
        System.out.println("salt pack!");
    };
}
