package leetcode;

/**
 * Description：<br>
 * 18:36 开始读题
 * 19:19 看懂题解
 * 19:55 写完答案
 * 20:45 答案AC
 * 这里有个重要的优化，就是在一个有序数组中找到第一个小于目标值的位置，有非常简洁优雅的写法
 * CreateDate：2022/6/13 19:23 <br>
 */

//1 <= nums.length <= 2500
//-104 <= tmp <= 104
    
public class LengthOfLIS_300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int length = 0;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            if (tmp > dp[length]) {
                length++;
                dp[length] = tmp;
            } else if (tmp < dp[length]){
                if (length == 0) {
                    dp[0] = tmp;
                } else {
                    int start = 0;
                    int end = length - 1;
                    int pos = -1;
                    while (start <= end) {
                        int middle = (start + end) / 2;
                        if (dp[middle] >= tmp) {
                            end = middle - 1;
                        } else {
                            start = middle + 1;
                            pos = middle;
                        }
                    }
                    dp[pos + 1] = tmp;
                }
            }
        }
        return length + 1;
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {10,9,2,5,3,7,101,18};
//        int[] nums = new int[] {4,10,4,3,8,9};
        int[] nums = new int[] {1,2,-10,-8,-7};
        LengthOfLIS_300 test = new LengthOfLIS_300();
        int answer = test.lengthOfLIS(nums);
    }

}
