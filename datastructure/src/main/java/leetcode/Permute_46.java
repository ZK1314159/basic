package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/8 11:34 <br>
 */
public class Permute_46 {

    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> candidate = new ArrayList<>();
        for (int i : nums) {
            candidate.add(i);
        }
        recursive(candidate, tmp);
        return answer;
    }

    void recursive(List<Integer> candidate, List<Integer> tmp) {
        if (candidate.isEmpty()) {
            answer.add(new ArrayList<>(tmp));
            return;
        }
        for (Integer integer : candidate) {
            tmp.add(integer);
            List<Integer> newCandidate = new ArrayList<>(candidate);
            newCandidate.remove(integer);
            recursive(newCandidate, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        Permute_46 test = new Permute_46();
        List<List<Integer>> answer = test.permute(nums);
    }

}
