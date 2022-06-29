package interview.historry.exam2022.zhaohang;

import java.util.ArrayList;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/26 16:41 <br>
 */
public class Test2 {

    public ArrayList<Integer> extraNum (String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        int tmp = 0;
        char left = '0';
        char right = '9';
        boolean isMinus = false;
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char charTmp = s.charAt(i);
            if (charTmp >= left && charTmp <= right) {
                if (!isMinus) {
                    if (tmp > 0) {
                        tmp = tmp * 10 + charTmp - left;
                    } else if (charTmp > left){
                        tmp = charTmp - left;
                    }
                }
            } else {
                if (tmp > 0) {
                    answer.add(tmp);
                    tmp = 0;
                }
                if (s.charAt(i) == '-') {
                    isMinus = true;
                } else {
                    isMinus = false;
                }
            }
        }
        if (tmp > 0) {
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "c12m-23b3n4t56";
        Test2 test2 = new Test2();
        ArrayList<Integer> answer = test2.extraNum(s);
    }

}
