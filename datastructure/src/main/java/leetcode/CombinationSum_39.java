package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/7 15:50 <br>
 */
@SuppressWarnings("unchecked")
public class CombinationSum_39 {
    boolean[] record;
    List[] listRecord;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        record = new boolean[target + 1];
        listRecord = new List[target + 1];
        for (int i = 0; i < listRecord.length; i++) {
            listRecord[i] = new ArrayList<ArrayList<Integer>>();
        }
        Arrays.sort(candidates);
        recursive(target, candidates);
        deleteRepeated(listRecord[target]);
        return listRecord[target];
    }
    
    public void recursive(int target, int[] candidates) {
        if (record[target]) {
            return;
        }
        Set<Integer> hasSearched = new HashSet<>();
        for (int tmp : candidates) {
            if (tmp > target) {
                break;
            } else if (tmp == target) {
                record[target] = true;
                listRecord[target].add(new ArrayList<>(Arrays.asList(target)));
            } else {
                recursive(target - tmp, candidates);
                if (hasSearched.contains(tmp)) {
                    continue;
                }
                if (listRecord[target - tmp].size() > 0) {
                    for (Object list : listRecord[target - tmp]) {
                        List<Integer> newTmp = (List<Integer>) list;
                        List<Integer> finalTmp = new ArrayList<>(newTmp);
                        finalTmp.add(tmp);
                        listRecord[target].add(finalTmp);
                    }
                }
            }
            hasSearched.add(tmp);
            hasSearched.add(target - tmp);
        }
        record[target] = true;
    }

    public void deleteRepeated(List<List<Integer>> listList) {
        for (List<Integer> list : listList) {
            Collections.sort(list);
        }
        Set<List<Integer>> set = new HashSet<>(listList);
        listList.clear();
        listList.addAll(set);
    }

    public static void main(String[] args) {
        CombinationSum_39 test = new CombinationSum_39();
        int[] candidates = new int[] {2,3,6,7};
        List<List<Integer>> answer = test.combinationSum(candidates, 7);
    }

}
