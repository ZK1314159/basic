package a_test;

/**
 * Description：<br>
 *
 * @author zeng.kai <br>
 * TaskId：<br>
 * CreateDate：historry.exam2018/10/14 18:24 <br>
 */
public class VariableScopeTest {
    public static void main(String[] args) {
        if (true) {
            int i = 1;
            System.out.println();
        }
        for (int i = 0; i < 10; i++) {
        }
        {
            int i = 2;
        }
        int i = 0;
    }
}
