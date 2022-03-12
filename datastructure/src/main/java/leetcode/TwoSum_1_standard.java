package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Description：<br>
 * 11:12 开始读题
 * 11:15 想到算法
 * 11:33 写完算法
 * 11:54 算法AC
 * 12:24 官方算法AC
 * CreateDate：2022/3/12 11:25 <br>
 */
public class TwoSum_1_standard {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        Integer i = 0;

        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,4};
        TwoSum_1_standard test = new TwoSum_1_standard();
        int[] answer = test.twoSum(nums, 6);
    }

}
