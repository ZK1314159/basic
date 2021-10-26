package a_test;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/4/24 22:43 <br>
 */
public class ObjectInitialTest {

    Set_Test test;

    public static void main(String[] args) {
        ObjectInitialTest myTest = new ObjectInitialTest();
        boolean result = (myTest.test == null);
        System.out.println(result);
    }
}
