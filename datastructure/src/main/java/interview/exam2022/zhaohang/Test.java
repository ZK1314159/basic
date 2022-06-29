package interview.historry.exam2022.zhaohang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/26 16:10 <br>
 */
public class Test {

    public String maxDictionaryOrder (String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        int position = 0;
        int max = (int) s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) > max) {
                position = i;
                max = s.charAt(i);
            }
        }
        List<Character> sub = new ArrayList<>();
        int left = position;
        int right = s.length() - 2;
        int min = s.charAt(s.length() - 1);
        sub.add((char) min);
        while (right >= left) {
            int tmp = s.charAt(right);
            if (tmp > min) {
                min = tmp;
                sub.add((char) tmp);
            } else if (tmp == min) {
                sub.add((char) tmp);
            }
            right--;
        }

        Collections.reverse(sub);
        char[] result = new char[sub.size()];
        for (int i = 0; i < sub.size(); i++) {
            result[i] = sub.get(i);
        }

        return String.valueOf(result);
    }

    public static void main(String[] args) {
//        String s = "aabcbccacbbcbaaba";
        String s = "cmbchina";
        Test test = new Test();
        String s1 = test.maxDictionaryOrder(s);
    }

}
