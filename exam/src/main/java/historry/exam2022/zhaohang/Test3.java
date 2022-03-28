package historry.exam2022.zhaohang;

import java.util.ArrayList;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/26 17:03 <br>
 */
public class Test3 {

    public ArrayList<Integer> extraNum (String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        int tmp = -1;
        char left = '0';
        char right = '9';
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char charTmp = s.charAt(i);
            if (charTmp >= left && charTmp <= right) {
                if (tmp > -1) {
                    if (tmp == 0) {
                        tmp = charTmp - left;
                    } else {
                        tmp = tmp * 10 + charTmp - left;
                    }
                } else if (charTmp > left){
                    tmp = charTmp - left;
                }
            } else if (tmp > -1) {
                answer.add(tmp);
                tmp = 0;
            }
        }
        if (tmp > -1) {
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "c12m23b0n4t56";
        Test3 test2 = new Test3();
        ArrayList<Integer> answer = test2.extraNum(s);
    }

}
