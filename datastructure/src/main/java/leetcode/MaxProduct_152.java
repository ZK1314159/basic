package leetcode;

/**
 * Description：<br>
 * 16:30开始看题
 * 16:43 想到解法
 * 该题花费了很长的时间
 * CreateDate：2022/6/1 16:43 <br>
 */
public class MaxProduct_152 {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int answer = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            if (tmp > 0) {
                max = Math.max(max * tmp, tmp);
                min = Math.min(min * tmp, tmp);
            } else if (tmp < 0) {
                int maxTmp = max;
                max = Math.max(min * tmp, tmp);
                min = Math.min(maxTmp * tmp, tmp);
            } else {
                max = 0;
                min = 0;
            }
            answer = Math.max(max, answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = new int[] {-4,-3,-2};
        MaxProduct_152 test = new MaxProduct_152();
        int answer = test.maxProduct(array);
    }

}
