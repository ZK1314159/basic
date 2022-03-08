package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：<br>
 * <br>
 * 11:21开始读题
 * 11:33想好算法
 * 11:51写完算法
 * 12:05算法AC
 * 12:34官方算法AC
 * CreateDate：2022/3/8 11:34 <br>
 */
public class Permute_46_standard {

    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        recursive(0, nums);
        return answer;
    }

    void recursive(int left, int[] nums) {
        if (left >= nums.length - 1) {
            generateList(left, nums);
            return;
        }
        for (int i = left; i < nums.length; i++) {
            if (i > left) {
                exchange(left, i, nums);
            }
            recursive(left + 1, nums);
            if (i > left) {
                exchange(left, i, nums);
            }
        }
    }

    void generateList(int right, int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= right; i++) {
            list.add(nums[i]);
        }
        answer.add(list);
    }

    void exchange(int left, int right, int[] nums) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        Permute_46_standard test = new Permute_46_standard();
        List<List<Integer>> answer = test.permute(nums);
    }

}
