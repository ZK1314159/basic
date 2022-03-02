package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/2 16:25 <br>
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        Set<Character> set = new HashSet<>();
        int right = 0;
        set.add(s.charAt(0));
        int max = 1;
        for (int left = 0; left < s.length(); left++) {
            while (right < s.length() - 1 && !set.contains(s.charAt(right + 1))) {
                right++;
                set.add(s.charAt(right));
                max = Math.max(max, right - left + 1);
            }
            if ((s.length() - left) <= max) {
                break;
            }
            set.remove(s.charAt(left));
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "bbbbb";
        LengthOfLongestSubstring test = new LengthOfLongestSubstring();
        int result = test.lengthOfLongestSubstring(s);
    }


}
