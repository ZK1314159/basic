package javase;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/5/8 16:04 <br>
 */
public class WrapperClassTest {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 321L;
        System.out.println(c == d);//true
        System.out.println(e == f);//false
        System.out.println(c == (a + b));//true
        System.out.println(c.equals(a + b));//true
        System.out.println(g == (a + b));//false
        System.out.println(g.equals(a + b));//false
    }
}
