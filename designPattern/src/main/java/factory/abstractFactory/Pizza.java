package main.java.factory.abstractFactory;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/29 11:28 <br>
 */
public abstract class Pizza {

    IngredientFactory ingredientFactory;

    Dough dough;

    Sauce sauce;

    abstract void prepare();

    abstract void bake();

    abstract void cut();

    abstract void pack();

    public void setIngredientFactory(IngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }
}
