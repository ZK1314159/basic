package decorator;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/28 14:24 <br>
 */
public class DecoratorTest {

    public static void main(String[] args) {
        MilkyTea milk = new Milk();
        MilkyTea milkPearl = new Pearl(milk);
        MilkyTea milkPearlBanana = new Banana(milkPearl);
        System.out.println(milkPearlBanana.getDescription());
        System.out.println("price: " + milkPearlBanana.cost());
    }
}
