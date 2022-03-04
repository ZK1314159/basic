package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/4 12:03 <br>
 */
public class ThreeSum_15_standard {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length <= 2) {
            return result;
        }

        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1;
            int third = nums.length - 1;
            // 优化空间: 方法还可以更快截断，避免循环
            while (second < third) {
                if (nums[third] + nums[first] + nums[second] > 0) {
                    third--;
                } else if (nums[third] + nums[first] + nums[second] == 0) {
                    if (second == first + 1 || second > first + 1 && nums[second] != nums[second - 1]) {
                        List<Integer> tmp = Arrays.asList(nums[first], nums[second], nums[third]);
                        result.add(new ArrayList<>(tmp));
                    }
                    second++;
                    third--;
                } else {
                    second++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] sample = new int[] {34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,
//                -66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49};
//        int[] sample = new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        int[] sample = new int[] {-1,0,1,2,-1,-4};
        ThreeSum_15_standard test2 = new ThreeSum_15_standard();
        ThreeSum_15 test = new ThreeSum_15();
        List<List<Integer>> result = test2.threeSum(sample);
        test.sortResult(result);
        test.print(result);
    }
}
