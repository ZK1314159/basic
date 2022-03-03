package leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/2 17:14 <br>
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return s.substring(0, 1);
            }
        }

        TreeMap<Integer, Integer> candidate = new TreeMap<>();
        for (int i = 1; i <= s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                candidate.put(i - 1, 2);
                int start = i - 1;
                while (i + 1 <= s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                    candidate.put(start, candidate.get(start) + 1);
                    i++;
                }
                if (candidate.get(start) > 2) {
                    i--;
                }
            } else if (i + 1 <= s.length() - 1 && s.charAt(i - 1) == s.charAt(i + 1)) {
                candidate.put(i - 1, 3);
            }
        }
        int maxLength = 1;
        int head = 0;
        for (Map.Entry<Integer, Integer> entry : candidate.entrySet()) {
            Integer start = entry.getKey();
            Integer length = entry.getValue();
            if (length > maxLength) {
                maxLength = length;
                head = start;
            }
            boolean repeated = isRepeated(start, length, s);
            // 以重复模式匹配
            if (repeated) {
                // 匹配开头
                while (start - 1 >= 0) {
                    if (s.charAt(start - 1) == s.charAt(start)) {
                        start--;
                        length++;
                        if (length > maxLength) {
                            maxLength = length;
                            head = start;
                        }
                    } else {
                        break;
                    }
                }
                // 匹配结尾
                while (start + length <= s.length() - 1) {
                    if (s.charAt(start + length - 1) == s.charAt(start + length)) {
                        length++;
                        if (length > maxLength) {
                            maxLength = length;
                            head = start;
                        }
                    } else {
                        break;
                    }
                }
                if (s.length() == length) {
                    break;
                }
            }
            // 然后以普通模式匹配
            while (start - 1 >= 0 && start + length <= s.length() - 1) {
                if (s.charAt(start - 1) == s.charAt(start + length)) {
                    length += 2;
                    start--;
                    if (length > maxLength) {
                        maxLength = length;
                        head = start;
                    }
                } else {
                    break;
                }
            }
        }
        return s.substring(head, head + maxLength);
    }

    public boolean isRepeated(Integer start, Integer length, String s) {
        char tmp = s.charAt(start);
        for (int i = 1; i < length; i++) {
            if (tmp != s.charAt(start + i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LongestPalindrome test = new LongestPalindrome();
        String s = "abb";
        String result = test.longestPalindrome(s);
    }

}
