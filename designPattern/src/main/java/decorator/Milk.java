package decorator;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/28 14:20 <br>
 */
public class Milk extends MilkyTea {

    public int cost() {
        return 3;
    }

    public String getDescription() {
        return "The milkTea contains milk";
    }
}
