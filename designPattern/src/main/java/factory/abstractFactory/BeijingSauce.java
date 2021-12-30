package factory.abstractFactory;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/29 19:33 <br>
 */
public class BeijingSauce extends Sauce {

    public void setName(String name) {
        this.name = name;
    }

    public void getDescription() {
        System.out.println("beijingSauce");
    }
}
