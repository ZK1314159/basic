package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/7 15:50 <br>
 */
@SuppressWarnings("unchecked")
public class CombinationSum_39_standard {

    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> combine = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        recursive(target, candidates, 0);
        return answer;
    }
    
    public void recursive(int target, int[] candidates, int position) {
        if (target == 0) {
            answer.add(new ArrayList<>(combine));
            return;
        }
        if (position + 1 <= candidates.length - 1 && candidates[position + 1] <= target) {
            recursive(target, candidates, position + 1);
        }
        if (target - candidates[position] >= 0) {
            combine.add(candidates[position]);
            recursive(target - candidates[position], candidates, position);
            combine.remove(combine.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum_39_standard test = new CombinationSum_39_standard();
        int[] candidates = new int[] {2,3,6,7};
        List<List<Integer>> answer = test.combinationSum(candidates, 7);
    }

}
