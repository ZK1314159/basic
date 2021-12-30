package main.java.factory.abstractFactory;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/29 19:09 <br>
 */
public class BeijingIngredientFactory implements IngredientFactory {

    public Dough createDough() {
        return new BeijingDough();
    }

    public Sauce createSauce() {
        return new BeijingSauce();
    }
}
