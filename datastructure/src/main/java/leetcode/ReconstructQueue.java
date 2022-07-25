package leetcode;

import java.util.Arrays;

/**
 * Description：<br>
 * 11:06开始看题
 * 11:27 放弃，直接看题解
 * 12:03 完全看懂题解
 * 12:17 提交结果
 * 12:21 提交结果AC
 * CreateDate：2022/7/25 12:04 <br>
 */

//1 <= people.length <= 2000
//0 <= hi <= 106
//0 <= ki < people.length
//题目数据确保队列可以被重建
public class ReconstructQueue {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        int[][] ans = new int[people.length][];
        for(int[] man : people) {
            int space = man[1] + 1;
            for (int i = 0; i < people.length; i++) {
                if (ans[i] == null) {
                    space--;
                    if (space == 0) {
                        ans[i] = man;
                        break;
                    }
                }
            }
        }
        return ans;
    }

}
