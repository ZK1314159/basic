package algorithm;

import java.util.*;

public class Dp_Test {
    private boolean wordBreak(String s, Set<String> dict) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(i, new LinkedList<>());
        }
        dict.forEach(e -> {
            int start = 0;
            while (start < s.length() && (start = s.indexOf(e, start)) > -1) {
                map.get(start).add(e);
                start = start + 1;
            }
        });
        for (int i = map.size() - 1; i >= 0; i--) {
            if (!map.get(i).isEmpty()) {
                Iterator<String> it = map.get(i).iterator();
                while (it.hasNext()) {
                    String tmp = it.next();
                    if (i + tmp.length() < s.length()) {
                        if (map.get(i + tmp.length()).isEmpty()) {
                            it.remove();
                        }
                    }
                }
            }
        }
        return !map.get(0).isEmpty();
    }

    public static void main(String[] args) {
        Dp_Test dp = new Dp_Test();
        String s = "aaaaatest";
        Set<String> set = new HashSet<>();
        set.add("test");
        set.add("aa");
        boolean right = dp.wordBreak(s, set);
        System.out.println(right);
    }
}
