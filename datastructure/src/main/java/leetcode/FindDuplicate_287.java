package leetcode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/6/11 16:08 <br>
 */

//1 <= n <= 105
//nums.length == n + 1
//1 <= nums[i] <= n
//nums中只有一个整数出现两次或多次 ，其余整数均只出现一次

public class FindDuplicate_287 {

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
