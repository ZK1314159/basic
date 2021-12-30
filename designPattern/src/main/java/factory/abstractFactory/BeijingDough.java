package main.java.factory.abstractFactory;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/29 19:37 <br>
 */
public class BeijingDough extends Dough {

    public void setName(String name) {
        this.name = name;
    }

    public void getDescription() {
        System.out.println("beijingDough");
    }
}
