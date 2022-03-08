package leetcode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/8 20:29 <br>
 */
public class CanJump_55 {

    boolean[] record;

    public boolean canJump(int[] nums) {
        record = new boolean[nums.length];
        for (int i = 0; i < record.length; i++) {
            record[i] = true;
        }
        return recursive(0, nums);
    }

    boolean recursive(int position, int[] nums) {
        if (position >= nums.length - 1) {
            return true;
        }
        if (nums[position] == 0) {
            record[position] = false;
            return false;
        }
        for (int i = 1; i <= nums[position]; i++) {
            if (!record[position + i]) {
                continue;
            }
            boolean canJump = recursive(position + i, nums);
            if (canJump) {
                return true;
            }
        }
        record[position] = false;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,1,4};
        CanJump_55 test = new CanJump_55();
        boolean canJump = test.canJump(nums);
    }

}
