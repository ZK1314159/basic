package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Description：<br>
 * 19:10 开始看题
 * 19:28为止，没有想到合理的方法
 * 19:38 看懂题解
 * 19:58 写完答案
 * 19:58 答案AC
 * CreateDate：2022/5/20 19:37 <br>
 */
public class LongestConsecutive_128 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int tmp : nums) {
            set.add(tmp);
        }
        int maxLength = 1;
        for (int tmp : nums) {
            if (set.contains(tmp - 1)) {
                continue;
            }
            int tmpLength = 1;
            while (set.contains(tmp + 1)) {
                tmpLength++;
                tmp++;
            }
            maxLength = Math.max(tmpLength, maxLength);
        }

        return maxLength;
    }

}
