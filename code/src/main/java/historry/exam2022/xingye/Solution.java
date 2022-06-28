package historry.exam2022.xingye;

import java.util.HashMap;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/4/7 20:54 <br>
 */
public class Solution {

    public String longestWord (String[] words) {
        if (words == null || words.length <= 2) {
            return "";
        }
        HashMap<String, Integer> history = new HashMap<>();
        String answer = "";
        for (int i = 2; i < words.length; i++) {
            String tmp = words[i];
            for (int j = 0; j < i; j++) {
                String inner = words[j];
                String next = "";
                if (tmp.startsWith(inner) || tmp.endsWith(inner)) {
                    if (tmp.startsWith(inner)) {
                        next = tmp.substring(inner.length());
                    } else {
                        next = tmp.substring(0, tmp.length() - inner.length());
                    }
                } else {
                    continue;
                }

                if (next.equals(inner)) {
                    if (history.get(next) > 1) {
                        answer = choose(tmp, answer);
                    }
                } else if (history.containsKey(next)){
                    answer = choose(tmp, answer);
                }
            }
            if (history.containsKey(tmp)) {
                Integer number = history.get(tmp);
                history.put(tmp, ++number);
            } else {
                history.put(tmp, 1);
            }
        }

        return answer;
    }

    String choose(String tmp, String answer) {
        if (tmp.length() > answer.length()) {
            return tmp;
        } else if (tmp.length() == answer.length()) {
            if (tmp.equals(answer)) {
                return tmp;
            }
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) > answer.charAt(i)) {
                    return answer;
                } else if (tmp.charAt(i) < answer.charAt(i)) {
                    return tmp;
                }
            }
            return tmp;
        } else {
            return answer;
        }
    }

    public static void main(String[] args) {
        String[] words = new String[] {"apple","iOS","","nana","man","good","goodman", "fjdk", "fjdk", "fjdkfjdk"};
        Solution solution = new Solution();
        String answer = solution.longestWord(words);
    }

}
