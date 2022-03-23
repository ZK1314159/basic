package leetcode;

/**
 * Description：<br>
 * 16:30开始读题
 * 16:39 想到算法
 * 16:46 写完算法
 * 16:46 算法AC
 * 官方算法是在数组中维持一个0的队列，并记录队列的left和right坐标，然后将right的非0元素移动到left位置
 * CreateDate：2022/3/23 16:39 <br>
 */
public class MoveZeroes_283 {

    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        for (int i = nums.length - 1; i >= nums.length - count; i--) {
            nums[i] = 0;
        }
    }

}
