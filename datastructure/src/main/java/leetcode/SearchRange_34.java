package leetcode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/5 15:33 <br>
 */
public class SearchRange_34 {
    // 15:27开始
    // 15:32想到算法
    // 16:01写完算法
    public int[] searchRange(int[] nums, int target) {
        int position = recursive(0, nums.length - 1, target, nums);
        if (position == -1) {
            return new int[] {-1, -1};
        } else {
            int left = position;
            int right = position;
            if (position > 0) {
                int leftPosition = recursiveNew(0, position - 1, target, nums, true);
                if (leftPosition >= 0) {
                    left = leftPosition;
                }
            }
            if (position < nums.length - 1) {
                int rightPosition = recursiveNew(position + 1, nums.length - 1, target, nums, false);
                if (rightPosition >= 0) {
                    right = rightPosition;
                }
            }
            return new int[] {left, right};
        }
    }

    public int recursiveNew(int left, int right, int target, int[] nums, boolean isLeft) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (nums[middle] == target) {
            int position;
            if (isLeft) {
                position = recursiveNew(left, middle - 1, target, nums, true);
            } else {
                position = recursiveNew(middle + 1, right, target, nums, false);
            }
            if (position >= 0) {
                return position;
            } else {
                return middle;
            }
        } else if (nums[middle] > target) {
            return recursiveNew(left, middle - 1, target, nums, isLeft);
        } else {
            return recursiveNew(middle + 1, right, target, nums, isLeft);
        }
    }

    public int recursive(int left, int right, int target, int[] nums) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] > target) {
            return recursive(left, middle - 1, target, nums);
        } else {
            return recursive(middle + 1, right, target, nums);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
    }

}
