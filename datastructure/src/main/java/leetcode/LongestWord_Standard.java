package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Description：<br>
 * leetcode 面试题 17.15. 最长单词
 * 本质上是完全单词拼接问题，题目本身描述不清楚
 * CreateDate：2022/6/9 15:33 <br>
 */
public class LongestWord_Standard {

    String longestWord(String[] words) {
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        for (String str : words) {
            map.put(str, true);
        }
        Arrays.sort(words,(o1, o2)->{
            if(o1.length() == o2.length())
                return o1.compareTo(o2);
            else{
                return Integer.compare(o2.length(),o1.length());
            }
        });
        for (String s : words) {
            if (canBuildWord(s, true, map)) {
                System.out.println(s);
                return s;
            }
        }
        return "";
    }
    boolean canBuildWord(String str, boolean isOriginalWord,
                         HashMap<String, Boolean> map) {
        if (map.containsKey(str) && !isOriginalWord) {
            return map.get(str);
        }
        for (int i = 1; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i);
            if (map.containsKey(left) && map.get(left) &&
                    canBuildWord(right, false, map)) {
                return true;
            }
        }
        map.put(str, false);
        return false;
    }

    public static void main(String[] args) {
        String[] strings = new String[] {"catcat", "cat", "dog"};
        LongestWord_Standard test = new LongestWord_Standard();
        String answer = test.longestWord(strings);
        Set<String> set = new HashSet<>();
        set.contains("jfdk");
    }

}
