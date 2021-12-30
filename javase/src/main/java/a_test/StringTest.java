package main.java.a_test;

/**
 * Description：<br>
 *
 * CreateDate：historry.exam2019/10/28 14:24 <br>
 */
public class StringTest {
    String string = "test";
    //string = "why";
    private int number = 1;
    private void modifyString(String string) {
        string = "new";
    }
    private void modifyString(int number) {
        number = 2;
    }
    private void modifySort(Sort sort) {
        sort.number = 3;
    }
    public static void main(String[] args) {
        Sort sort = new Sort();
        sort.number = 2;
        StringTest test = new  StringTest();
        test.modifySort(sort);
        test.modifyString(test.string);
        System.out.println(sort.number);
        System.out.println(test.string);
        System.out.println(test.number);
    }
}
