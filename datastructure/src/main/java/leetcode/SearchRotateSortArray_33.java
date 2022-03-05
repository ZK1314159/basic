package leetcode;

/**
 * Description：<br>
 * <br>
 * 思考算法，8分钟
 * 写算法，60分钟
 * 存在问题：一开始想的算法没有利用上一些条件，过于复杂
 * CreateDate：2022/3/5 13:01 <br>
 */
public class SearchRotateSortArray_33 {

    public int search(int[] nums, int target) {
        if (nums[0] > nums[nums.length - 1]) {
            return recursive1(0, nums.length - 1, nums, target);
        } else {
            return recursive2(0, nums.length - 1, nums, target);
        }
    }

    // left > right
    public int recursive1(int left, int right, int[] nums, int target) {
        if (right - left <= 2) {
            return judge(left, right, nums, target);
        }
        int middle = (left + right) / 2;
        if (nums[middle] == target) {
            return middle;
        }
        if (nums[middle] > nums[left]) {
            if (nums[left] <= target && target < nums[middle]) {
                // 普通二分查找
                return recursive2(left, middle - 1, nums, target);
            } else {
                return recursive1(middle, right, nums, target);
            }
        } else {
            if (nums[middle] < target && target <= nums[right]) {
                return recursive2(middle + 1, right, nums, target);
            } else {
                return recursive1(left, middle, nums, target);
            }
        }
    }

    // left < right
    public int recursive2(int left, int right, int[] nums, int target) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] > target) {
            return recursive2(left, middle - 1, nums, target);
        } else {
            return recursive2(middle + 1, right, nums, target);
        }
    }

    public int judge(int left, int right, int[] nums, int target) {
        for (int i = left; i <= right; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
