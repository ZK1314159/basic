package leetcode.permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description：<br>
 * 单词无重复，并且每个单词只能用一次
 * CreateDate：2022/6/10 21:12 <br>
 */
public class StringConcat_01_Not_Repeated {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null || wordDict.size() == 0) {
            return false;
        }
        Set<String> wordSet = new HashSet<>(wordDict);
        if (s.length() == 0) {
            return wordSet.contains("");
        }
        int max = 0;
        for (String string : wordDict) {
            max = Math.max(max, string.length());
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (i - j + 1 > max) {
                    break;
                }
                if (dp[j] && wordSet.contains(s.substring(j, i + 1))
                        && !s.substring(0, j).contains(s.substring(j, i + 1))) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "dogcatdog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("dog");
        StringConcat_01_Not_Repeated test = new StringConcat_01_Not_Repeated();
        boolean answer = test.wordBreak(s, wordDict);
    }

}
