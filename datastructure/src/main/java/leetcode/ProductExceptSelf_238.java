package leetcode;

/**
 * Description：<br>
 * 15:06 开始读题
 * 15:09 想到算法
 * 15:13 想到最优算法
 * 15:24 写完算法
 * 15:27 算法AC
 * 15:33 算法优化到最佳
 * CreateDate：2022/6/4 15:15 <br>
 */

//        2 <= nums.length <= 105
//        -30 <= nums[i] <= 30
//        保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内

public class ProductExceptSelf_238 {

    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int tmp = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            tmp *= nums[i + 1];
            answer[i] *= tmp;
        }
        return answer;
    }

}
