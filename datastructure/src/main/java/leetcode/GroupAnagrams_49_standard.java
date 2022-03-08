package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description：<br>
 * 17:03 开始读题
 * 17:04 想到大致的算法
 * 17:50 写完算法
 * 17:50 算法AC
 * 18:02 官方算法AC
 * CreateDate：2022/3/8 17:22 <br>
 */
public class GroupAnagrams_49_standard {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        // 排序
        for (String string : strs) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            List<String> list = map.getOrDefault(sorted, new ArrayList<>());
            list.add(string);
            map.put(sorted, list);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[] {""};
        GroupAnagrams_49_standard test = new GroupAnagrams_49_standard();
        test.groupAnagrams(strs);
    }

}
