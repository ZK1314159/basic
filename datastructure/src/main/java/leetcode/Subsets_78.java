package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/11 16:04 <br>
 */
public class Subsets_78 {

    private List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        answer.add(new ArrayList<>());
        List<Integer> list = new ArrayList<>();
        for(int i : nums) {
            list.add(i);
        }
        answer.add(list);
        List<Integer> tmp = new ArrayList<>();
        // 遍历所有的子集长度
        for (int i = 1; i <= nums.length - 1; i++) {
            recursive(0, i, 1, nums, tmp);
        }
        return answer;
    }

    void recursive(int start, int maxLayer, int layer, int[] nums, List<Integer> tmp) {
        if (layer <= maxLayer) {
            for (int i = start; i <= nums.length - maxLayer + layer - 1; i++) {
                tmp.add(nums[i]);
                recursive(i + 1, maxLayer, layer + 1, nums, tmp);
                tmp.remove(tmp.size() - 1);
            }
        } else {
            answer.add(new ArrayList<>(tmp));
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        Subsets_78 test = new Subsets_78();
        test.subsets(nums);
    }

}
