package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description：<br>
 * 22:07 开始看题
 * 22:14 想到算法
 * 22:35 写完算法
 * 22:36 算法AC
 * 22:55 官方算法AC
 * CreateDate：2022/3/8 22:15 <br>
 */
public class Merge_56_standard {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> {
            if (v1[0] != v2[0]) {
                return Integer.compare(v1[0], v2[0]);
            } else {
                return Integer.compare(v2[1], v1[1]);
            }
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        List<int[]> listTmp = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int[] value = intervals[i];
            if (value[0] == left) {
                continue;
            }
            if (value[0] > right) {
                listTmp.add(new int[]{left, right});
                left = value[0];
                right = value[1];
            } else if (value[1] > right){
                right = value[1];
            }
        }
        listTmp.add(new int[]{left, right});
        return listTmp.toArray(new int[listTmp.size()][2]);
    }

}
