package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/2/19 14:15 <br>
 */
public class ValidBracket {

    Map<Character, Character> map = new HashMap<>(3);

    public boolean isValid(String s) {

        if (s.length() % 2 == 1) {
            return false;
        }

        // 构造映射
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (map.containsKey(tmp)) {
                if (deque.isEmpty() || deque.poll() != map.get(tmp)) {
                    return false;
                }
            } else {
                deque.push(tmp);
            }
        }

        return deque.isEmpty();
    }



    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.poll();
        ValidBracket validBracket = new ValidBracket();
        boolean isValid = validBracket.isValid("([]{}{{}})[][[[]]](())");
    }

}
