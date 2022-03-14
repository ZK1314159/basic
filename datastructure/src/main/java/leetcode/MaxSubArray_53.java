package leetcode;

/**
 * Description：<br>
 * 22:03 开始看题
 * 22:53 看题解后有最佳思路
 * 23:02 写完算法
 * 23:02 算法AC
 * CreateDate：2022/3/14 22:54 <br>
 */
public class MaxSubArray_53 {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int maxNow = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxNow = Math.max(nums[i], nums[i] + maxNow);
            max = Math.max(max, maxNow);
        }
        return max;
    }

}
