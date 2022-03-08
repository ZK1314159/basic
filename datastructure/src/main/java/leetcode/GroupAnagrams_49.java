package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/8 17:22 <br>
 */
public class GroupAnagrams_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        // 排序
        for (String string : strs) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            List<String> list = map.get(sorted);
            if (list == null) {
                List<String> list1 = new ArrayList<>();
                list1.add(string);
                map.put(sorted, list1);
            } else {
                list.add(string);
            }
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[] {""};
        GroupAnagrams_49 test = new GroupAnagrams_49();
        test.groupAnagrams(strs);
    }

}
