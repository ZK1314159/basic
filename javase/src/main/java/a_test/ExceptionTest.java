package a_test;

/**
 * Description：<br>
 *
 * @author zeng.kai <br>
 * TaskId：<br>
 * CreateDate：historry.exam2019/10/7 15:13 <br>
 */
public class ExceptionTest {
    private int id;

    private void exceptionTest() {
        Sort test = new Sort();
        test = null;
        System.out.println(test.number);
    }
    public static void main(String[] args) {
        ExceptionTest test = new ExceptionTest();
        try {
            test.exceptionTest();
        }
        catch (NullPointerException e){
            System.out.println("find NullPointerException");
        }
        System.out.println("progress has not end");
        //System.out.println(newId);
    }
}


