package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/12 11:25 <br>
 */
public class TwoSum_1 {

    public int[] twoSum(int[] nums, int target) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new int[] {i, nums[i]});
        }
        list.sort(Comparator.comparingInt(v -> v[1]));
        int left = 0;
        int right = list.size() - 1;
        if (target > list.get(right)[1] * 2 || target < list.get(left)[1] * 2) {
            return null;
        }
        while (left < right) {
            if (list.get(left)[1] + list.get(right)[1] == target) {
                return new int[]{list.get(left)[0], list.get(right)[0]};
            } else if (list.get(left)[1] + list.get(right)[1] > target) {
                right--;
            } else {
                left++;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,4};
        TwoSum_1 test = new TwoSum_1();
        int[] answer = test.twoSum(nums, 6);
    }

}
