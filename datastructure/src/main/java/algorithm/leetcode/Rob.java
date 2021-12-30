package main.java.algorithm.leetcode;

/**
 * Description：leetcode_198
 * <br>
 * CreateDate：2021/11/5 15:04 <br>
 */
public class Rob {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // 类似于阶梯问题
        // 某一天的最优偷窃金额是可以从昨日或者更早一天的最优偷窃金额得到
        // 往前推3天那天的最优偷窃金额可以通过偷或者不偷到达昨日或者2天前
        int dpn = Math.max(nums[0], nums[1]);
        int dpn_1 = nums[0];
        int position = 2;
        while (position <= nums.length - 1) {
            int tmp = dpn;
            dpn = Math.max(dpn, dpn_1 + nums[position]);
            dpn_1 = tmp;
            position++;
        }
        return dpn;
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        int[] nums = new int[]{178,9,123,124}; //dp1 = 178; dp2 = 178; dp3 = 301; dp4 = 302
        int result = rob.rob(nums);
        System.out.println(result);
    }
}
