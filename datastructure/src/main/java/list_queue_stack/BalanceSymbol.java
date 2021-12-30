package list_queue_stack;

import java.util.*;

class BalanceSymbol {
    LinkedList<String> list = new LinkedList<>();

    void balanceTest(String[] s, Map<String, String> map) throws Exception {
        for (int i = 0; i < s.length; i++) {
            if (map.containsValue(s[i])) {
                list.push(s[i]);
            } else if (map.containsKey(s[i])) {
                if (list.isEmpty()) {
                    throw new Exception("Exception: symbol balance is broken");
                }
                String st = list.pop();
                if (!st.equals(map.get(s[i]))) {
                    throw new Exception("symbol balance is broken");
                }
            }
            if (i == s.length - 1 && !list.isEmpty()) {
                throw new Exception("Exception: symbol balance is broken");
            }
        }
    }

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("*/", "/*");
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");
        BalanceSymbol balance = new BalanceSymbol();
        String[] s = {"/*", "*/", "(", "[", "]", "{", "}"};
        try {
            balance.balanceTest(s, map);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
