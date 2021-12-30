package factory.simpleFactory;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/29 11:33 <br>
 */
public class SimplePizzaStore {
    Pizza createPizza(String name) {
        switch (name) {
            case "salt":
                return new SaltPizza();
            case "sweet":
                return new SweetPizza();
            default:
                return new SaltPizza();
        }
    }
}
