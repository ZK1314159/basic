package factory.abstractFactory;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/29 19:40 <br>
 */
public class PizzaPurchase {

    public static void main(String[] args) {
        IngredientFactory ingredientFactory = new BeijingIngredientFactory();
        Pizza pizza = new CheesePizza(ingredientFactory);
        pizza.prepare();
        pizza.dough.getDescription();
        pizza.sauce.getDescription();
    }
}
