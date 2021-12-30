package decorator;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/28 14:16 <br>
 */
public class Pearl extends Ingredient {

    Pearl(MilkyTea milkyTea) {
        this.milkyTea = milkyTea;
    }

    public int cost() {
        return 1 + milkyTea.cost();
    }

    public String getDescription() {
        return milkyTea.getDescription() + ", pearl";
    }
}
