package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/8 22:15 <br>
 */
public class Merge_56 {

    public int[][] merge(int[][] intervals) {
        List<int[]> list = Arrays.asList(intervals);
        list.sort(Comparator.comparingInt(v -> v[0]));
        List<int[]> listTmp = new ArrayList<>();
        int left = list.get(0)[0];
        int right = list.get(0)[1];
        for (int i = 1; i < list.size(); i++) {
            int[] value = list.get(i);
            if (value[0] > right) {
                listTmp.add(new int[]{left, right});
                left = value[0];
                right = value[1];
            } else if (value[1] > right){
                right = value[1];
            }
        }
        listTmp.add(new int[]{left, right});
        int[][] answer = new int[listTmp.size()][2];
        for (int i = 0; i < listTmp.size(); i++) {
            answer[i] = listTmp.get(i);
        }
        return answer;
    }

}
