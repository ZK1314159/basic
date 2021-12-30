package a_test;

/**
 * Description：<br>
 * <br>
 * CreateDate：historry.exam2019/11/6 14:01 <br>
 */
public class LongToStringTest {
    Long number;
    public static void main(String[] args) {
        LongToStringTest test = new LongToStringTest();
        String tmp = String.valueOf(test.number);
        System.out.println(tmp.charAt(0));
    }
}
