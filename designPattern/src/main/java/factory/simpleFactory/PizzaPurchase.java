package factory.simpleFactory;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/29 16:37 <br>
 */
public class PizzaPurchase {

    public static void main(String[] args) {
        SimplePizzaStore simplePizzaFactory = new SimplePizzaStore();
        Pizza pizza = simplePizzaFactory.createPizza("salt");
        pizza.bake();
        pizza.pack();
    }
}
