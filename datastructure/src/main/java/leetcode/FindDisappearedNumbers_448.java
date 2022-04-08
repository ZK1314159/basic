package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：<br>
 * 15:26开始看题
 * 15:55 看懂官方解答
 * 15:59 写完答案
 * 16:03 答案AC
 * CreateDate：2022/4/8 15:55 <br>
 */
public class FindDisappearedNumbers_448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        for (int tmp : nums) {
            int value = (tmp - 1) % length;
            nums[value] += length;
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (nums[i] <= length) {
                answer.add(i + 1);
            }
        }
        return answer;
    }

}
