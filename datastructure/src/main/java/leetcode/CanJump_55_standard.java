package leetcode;

/**
 * Description：<br>
 * 20:17 开始看题
 * 20:28 想到大致算法
 * 20:44 写完算法
 * 20:50 算法AC
 * 21:10 官方算法AC
 * CreateDate：2022/3/8 20:29 <br>
 */
public class CanJump_55_standard {

    public boolean canJump(int[] nums) {
        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= nums.length - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,1,4};
        CanJump_55_standard test = new CanJump_55_standard();
        boolean canJump = test.canJump(nums);
    }

}
