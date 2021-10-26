package factory.factory;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/29 17:03 <br>
 */
public class NewYorkPizzaStore implements PizzaStore {

    public Pizza createPizza(String name) {
        switch (name) {
            case "salt":
                return new NewYorkSaltPizza ();
            case "sweet":
                return new NewYorkSweetPizza ();
            default:
                return new NewYorkSaltPizza();
        }
    }
}
