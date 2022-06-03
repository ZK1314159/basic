package leetcode;

import java.util.HashMap;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/6/3 14:00 <br>
 */
// 1 <= word.length, prefix.length <= 2000
// word 和 prefix 仅由小写英文字母组成
//  insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次

public class Trie_208 {

    private Node root = new Node();

    public static class Node {
        private HashMap<Character, Node> son = new HashMap<>();
        private boolean isEnd;
    }

    public Trie_208() {
    }

    public void insert(String word) {
        Node head = root;
        for (int i = 0; i < word.length(); i++) {
            char tmp = word.charAt(i);
            Node node = head.son.get(tmp);
            if (node == null) {
                node = new Node();
                head.son.put(tmp, node);
            }
            if (i == word.length() - 1) {
                node.isEnd = true;
            }
            head = node;
        }
    }

    public boolean search(String word) {
        Node head = root;
        for (int i = 0; i < word.length(); i++) {
            char tmp = word.charAt(i);
            Node node = head.son.get(tmp);
            if (node == null) {
                return false;
            }
            if (i == word.length() - 1) {
                return node.isEnd;
            }
            head = node;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        Node head = root;
        for (int i = 0; i < prefix.length(); i++) {
            char tmp = prefix.charAt(i);
            Node node = head.son.get(tmp);
            if (node == null) {
                return false;
            }
            head = node;
        }
        return true;
    }

}
