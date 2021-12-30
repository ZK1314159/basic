package main.java.decorator;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/28 14:21 <br>
 */
public class Banana extends Ingredient {

    Banana(MilkyTea milkyTea) {
        this.milkyTea = milkyTea;
    }

    public int cost() {
        return 1 + milkyTea.cost();
    }

    public String getDescription() {
        return milkyTea.getDescription() + ", banana";
    }
}
