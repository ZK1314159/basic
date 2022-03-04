package leetcode;

/**
 * Description：<br>
 * <br>
 * 想到算法：15分钟
 * 写算法：60分钟
 * 调试：6分钟
 * CreateDate：2022/3/4 17:41 <br>
 */
public class NextPermutation_31 {

    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        if (nums.length == 2) {
            exchange(0, 1, nums);
            return;
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                // 找出右边比num[i]大元素中最小的那个
                int position = i + 1;
                for (int j = i + 2; j <= nums.length - 1; j++) {
                    if (nums[j] <= nums[i]) {
                        position = j - 1;
                        break;
                    } else if (j == nums.length - 1){
                        position = j;
                    }
                }

                // 18:07
                exchange(i, position, nums);
                // 交换后的数据仍然是有序的

                // 20:07
                // 翻转数据
                int left = i + 1;
                int right = nums.length - 1;
                reverse(left, right, nums);
                break;
            } else if (i == 0) {
                // 翻转数据
                reverse(0, nums.length - 1, nums);
            }
        }
    }

    public void reverse(int left, int right, int[] nums) {
        while (left < right) {
            int leftTmp = nums[left];
            nums[left] = nums[right];
            nums[right] = leftTmp;
            left++;
            right--;
        }
    }

    public void exchange(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        NextPermutation_31 test = new NextPermutation_31();
        int[] nums = new int[] {5,4,7,5,3,2};
        // 1 3 4 2 5
        test.nextPermutation(nums);
    }

}
