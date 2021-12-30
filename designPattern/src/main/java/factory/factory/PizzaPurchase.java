package main.java.factory.factory;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/29 17:13 <br>
 */
public class PizzaPurchase {

    public static void main(String[] args) {
        //PizzaStore pizzaStore = new BeijingPizzaStore();
        PizzaStore pizzaStore = new NewYorkPizzaStore();
        Pizza pizza = pizzaStore.createPizza("sweet");
        pizza.cut();
        pizza.pack();
    }
}
