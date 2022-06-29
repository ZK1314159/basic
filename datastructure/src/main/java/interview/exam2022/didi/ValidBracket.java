package interview.historry.exam2022.didi;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/2/19 14:15 <br>
 */
public class ValidBracket {

    Map<Character, Character> map = new HashMap<>(3);
    Set<Character> right = new HashSet<>();
    String string = "";

    public boolean isValid(String s) {

        // 构造映射
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        // 构造右边字符集
        right.add(')');
        right.add('}');
        right.add(']');

        string = s;

        return judge(0, string.length() - 1);
    }

    boolean judge(int start, int end) {

        if (right.contains(string.charAt(start))) {
            return false;
        }

        if ((end - start) % 2 == 0) {
            return false;
        }

        if (end - start <= 1) {
            if (end - start <= 0) {
                return false;
            }
            if (string.charAt(end) != map.get(string.charAt(start))) {
                return false;
            }
            return true;
        }

        int middle = findPosition(start, end);
        if (middle < 0) {
            return false;
        }

        if (middle == end) {
            return judge(start + 1, end - 1);
        }

        boolean isLeftValid;
        if (middle == start + 1) {
            isLeftValid = true;
        } else {
            isLeftValid = judge(start + 1, middle - 1);
        }

        boolean isRightValid = judge(middle + 1, end);
        if (isLeftValid && isRightValid) {
            return true;
        }
        return false;
    }
    
    private int findPosition(int start, int end) {
        int leftCount = 1;
        if (start >= end) {
            return -1;
        }
        char tmp = string.charAt(start);
        char reverse = map.get(tmp);
        for (int j = start + 1; j <= end; j++) {
            char innerTmp = string.charAt(j);
            if (innerTmp == tmp) {
                leftCount++;
            }
            if (innerTmp == reverse) {
                if (leftCount == 1) {
                    return j;
                } else {
                    leftCount--;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.poll();
        ValidBracket validBracket = new ValidBracket();
        boolean isValid = validBracket.isValid("([]{}{{}})[][[[]]](())");
    }

}
