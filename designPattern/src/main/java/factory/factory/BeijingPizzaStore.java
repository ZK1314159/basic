package main.java.factory.factory;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/29 17:03 <br>
 */
public class BeijingPizzaStore implements PizzaStore {

    public Pizza createPizza(String name) {
        switch (name) {
            case "salt":
                return new BeijingSaltPizza ();
            case "sweet":
                return new BeijingSweetPizza ();
            default:
                return new BeijingSaltPizza();
        }
    }
}
