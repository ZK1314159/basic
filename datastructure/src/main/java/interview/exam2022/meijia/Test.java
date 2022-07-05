package interview.exam2022.meijia;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/7/5 20:27 <br>
 */
public class Test {

    public String sum(String s1, String s2, String s3) {
        int length = Math.max(Math.max(s1.length(), s2.length()), s3.length());
        StringBuilder stringBuilder = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (i < s1.length()) {
                sum += s1.charAt(s1.length() - i - 1) - '0';
            }
            if (i < s2.length()) {
                sum += s2.charAt(s2.length() - i - 1) - '0';
            }
            if (i < s3.length()) {
                sum += s3.charAt(s3.length() - i - 1) - '0';
            }
            stringBuilder.append(sum % 10);
            sum = sum / 10;
        }
        if (sum > 0) {
            stringBuilder.append(sum);
        }

        return stringBuilder.reverse().toString();
    }
    public static void main(String[] args) {
        Test showMeBug = new Test();
        System.out.println(showMeBug.sum("9999999999999999", "1", "1"));
    }

}
