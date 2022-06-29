package a_test;

/**
 * Description：<br>
 * <p>
 * CreateDate：interview.historry.exam2018/10/30 14:37 <br>
 */
public class StringBuilderTest {
    private StringBuilder sb = new StringBuilder();
    private void test(StringBuilder sb) {
        sb.append("haha");
    }
    public static void main(String[] args) {
        StringBuilderTest sbTest = new StringBuilderTest();
        sbTest.test(sbTest.sb);
        System.out.println(sbTest.sb);
    }
}
