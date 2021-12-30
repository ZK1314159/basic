package list_queue_stack;

import java.util.*;

class TransferToPostfix {
    String transferTo(String s, Map<Character, Integer> map, LinkedList<Character> list) {
        StringBuilder st = new StringBuilder();
        String st2 = "";
        for (int i = 0; i < s.length(); i++) {
            if (48 <= s.charAt(i) && s.charAt(i) <= 57) {
                st.append(s.charAt(i));
            } else if (list.isEmpty()) {
                list.push(s.charAt(i));
            } else if (map.get(s.charAt(i)) > map.get(list.peek())) {
                if (s.charAt(i) == ')') {
                    while (!(list.peek() == '(')) {
                        st.append(list.pop());
                    }
                    list.pop();
                } else {
                    list.push(s.charAt(i));
                }

            } else {
                if (list.peek() == '(') {
                    list.push(s.charAt(i));
                } else {
                    st.append(list.pop());
                    while (!list.isEmpty()) {
                        if (map.get(s.charAt(i)) <= map.get(list.peek()) && !(list.peek() == '(')) {
                            st.append(list.pop());
                        }
                    }
                    list.push(s.charAt(i));
                }
            }
            if (i == s.length() - 1) while (!list.isEmpty()) {
                st.append(list.pop());
            }
        }
        st2 = st.toString();
        return st2;
    }

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('(', 3);
        map.put(')', 3);
        map.put('*', 2);
        map.put('/', 2);
        map.put('+', 1);
        map.put('-', 1);
        String s = "3-4+5*(6+7)+4/2";
        LinkedList<Character> list = new LinkedList<>();
        TransferToPostfix transfer = new TransferToPostfix();
        String st = transfer.transferTo(s, map, list);
        System.out.println(st);
    }
}
