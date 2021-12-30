package factory.abstractFactory;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/29 19:21 <br>
 */
public class CheesePizza extends Pizza {

    CheesePizza(IngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    public void prepare() {
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
    }

    public void bake() {
        System.out.println("Beijing pizza bake!");
    }

    public void cut() {
        System.out.println("Beijing pizza cut!");
    }

    public void pack() {
        System.out.println("Beijing pizza pack!");
    }
}
