package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/4 16:35 <br>
 */
public class GenerateParenthesis_22 {

    List<String> answer = new ArrayList<>();
    int length;

    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            answer.add("()");
            return answer;
        }
        length = n;
        recursive(1, 1, "(", "(");
        recursive(1, 1, "(", ")");
        return answer;
    }

    public void recursive(int left, int total, String pre, String now) {
        total++;
        if (now.equals("(")) {
            left++;
        }
        if (left >= total - left && left <= length) {
            if (left == length) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < length * 2 - total; i++) {
                    stringBuilder.append(")");
                }
                answer.add(pre + now + stringBuilder.toString());
            } else {
                pre = pre + now;
                recursive(left, total, pre, "(");
                recursive(left, total, pre, ")");
            }
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis_22 test = new GenerateParenthesis_22();
        List<String> answer = test.generateParenthesis(3);
    }

}
