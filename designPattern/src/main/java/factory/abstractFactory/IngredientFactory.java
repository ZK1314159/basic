package main.java.factory.abstractFactory;


/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/29 11:32 <br>
 */
public interface IngredientFactory {
    Dough createDough();
    Sauce createSauce();
}
