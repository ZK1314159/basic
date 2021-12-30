package proxy.cglib;

/**
 * Description：<br>
 * <br>
 * CreateDate：2021/12/29 21:21 <br>
 */
public class Target {

    public String test(String input) {
        System.out.println("args: " + input);
        return input;
    }

}
