package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：<br>
 * 15:37 开始看题 
 * 16:03 想到算法 
 * 16:34 写完算法 
 * 16:48 算法AC
 * 17:08 官方算法AC
 * CreateDate：2022/3/11 16:04 <br>
 */
public class Subsets_78_standard {

    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return answer;
    }

    void dfs(int current, int[] nums) {
        if (current == nums.length) {
            answer.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[current]);
        dfs(current + 1, nums);
        tmp.remove(tmp.size() - 1);
        dfs(current + 1, nums);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        Subsets_78_standard test = new Subsets_78_standard();
        test.subsets(nums);
    }

}
