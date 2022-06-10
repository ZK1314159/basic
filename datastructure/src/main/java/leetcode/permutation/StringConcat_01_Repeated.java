package leetcode.permutation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description：<br>
 * 单词有重复，并且每个单词只能用一次
 * CreateDate：2022/6/10 21:12 <br>
 */
public class StringConcat_01_Repeated {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null || wordDict.size() == 0) {
            return false;
        }
        int max = 0;
        Map<String, Integer> wordCount = new HashMap<>(wordDict.size());
        for (String string : wordDict) {
            max = Math.max(max, string.length());
            wordCount.merge(string, 1, Math::addExact);
        }
        if (s.length() == 0) {
            return wordCount.containsKey("");
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (i - j + 1 > max) {
                    break;
                }
                String right = s.substring(j, i + 1);
                if (dp[j] && wordCount.containsKey(right)) {
                    int count = wordCount.get(right);
                    int leftCount = getCount(s.substring(0, j), right);
                    if (leftCount <= count - 1) {
                        dp[i + 1] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }

    public int getCount(String string, String target) {
        if (string.length() == 0) {
            return 0;
        }
        int start = 0;
        int count = 0;
        while (start < string.length()) {
            int index = string.indexOf(target, start);
            if (index == -1) {
                break;
            }
            count++;
            start = index + target.length();
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "dogcatdogcat";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("dog");
        wordDict.add("dog");
        wordDict.add("cat");
        StringConcat_01_Repeated test = new StringConcat_01_Repeated();
        boolean answer = test.wordBreak(s, wordDict);
    }

}
