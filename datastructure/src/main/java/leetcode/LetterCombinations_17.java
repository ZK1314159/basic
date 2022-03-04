package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/4 15:19 <br>
 */
public class LetterCombinations_17 {

    int[] numbers;
    Map<Integer, List<String>> map = new HashMap<>(8);
    List<String> answer = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return answer;
        }
        numbers = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            numbers[i] = (int) digits.charAt(i) - 48;
        }
        map.put(2, Arrays.asList("a", "b", "c"));
        map.put(3, Arrays.asList("d", "e", "f"));
        map.put(4, Arrays.asList("g", "h", "i"));
        map.put(5, Arrays.asList("j", "k", "l"));
        map.put(6, Arrays.asList("m", "n", "o"));
        map.put(7, Arrays.asList("p", "q", "r", "s"));
        map.put(8, Arrays.asList("t", "u", "v"));
        map.put(9, Arrays.asList("w", "x", "y", "z"));

        create("", 0);
        return answer;
    }

    public void create(String pre, int now) {
        if (now > numbers.length - 1) {
            answer.add(pre);
            return;
        }
        int num = numbers[now];
        List<String> strings = map.get(num);
        for (String tmp : strings) {
            create(pre + tmp, now + 1);
        }
    }

    public static void main(String[] args) {
        String string = "23";
        LetterCombinations_17 test = new LetterCombinations_17();
        List<String> answer = test.letterCombinations(string);
    }

}
