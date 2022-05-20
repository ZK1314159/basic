package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description：<br>
 * 21:31开始看题
 * 21:49 没有特别好的想法
 * 22:00 看完官方题解
 * 22:20 写完答案
 * 22:22 答案AC 
 * CreateDate：2022/5/20 23:07 <br>
 */
public class WordBreak_139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] history = new boolean[s.length() + 1];
        history[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (history[j] && wordSet.contains(s.substring(j, i))) {
                    history[i] = true;
                    break;
                }
            }
        }
        return history[s.length()];
    }

}
