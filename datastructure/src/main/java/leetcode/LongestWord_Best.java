package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Description：<br>
 * leetcode 面试题 17.15. 最长单词
 * 本质上是leetcode单词拆分问题，参考：https://leetcode.cn/problems/word-break/
 * 本题题目描述极其含糊，准确的描述是单词可重复，并且每次单词可以多次使用。
 * CreateDate：2022/6/9 15:33 <br>
 */

// 0 <= len(words) <= 200
// 1 <= len(words[i]) <= 100
public class LongestWord_Best {

    String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        // 先排序
        Arrays.sort(words, (o1, o2) -> {
            if(o1.length() == o2.length())
                return o1.compareTo(o2);
            else{
                return Integer.compare(o2.length(), o1.length());
            }
        });
        HashSet<String> set = new HashSet<>(words.length);
        Collections.addAll(set, words);
        for (String s : words) {
            // 单词可能有重复
            if (set.remove(s)) {
                if (wordBreak(s, set)) {
                    return s;
                }
            }
        }
        return "";
    }

    public boolean wordBreak(String s, Set<String> wordSet) {
        if (s == null || wordSet == null || wordSet.size() == 0) {
            return false;
        }
        if (s.length() == 0) {
            return wordSet.contains("");
        }
        int max = 0;
        for (String string : wordSet) {
            max = Math.max(max, string.length());
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (i - j + 1 > max) {
                    break;
                }
                if (dp[j] && wordSet.contains(s.substring(j, i + 1))) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String[] strings = new String[] {"catcat", "cat", "dog"};
        LongestWord_Best test = new LongestWord_Best();
        String answer = test.longestWord(strings);
        Set<String> set = new HashSet<>();
        set.contains("jfdk");
    }

}
