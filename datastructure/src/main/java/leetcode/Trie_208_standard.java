package leetcode;

/**
 * Description：<br>
 * 13:50 开始读题
 * 13:57 想到解法
 * 14:24 写完解法
 * 14:25 解法AC
 * 14:34 看懂官方解答
 * 14:50 官方解答AC
 * CreateDate：2022/6/3 14:00 <br>
 */
// 1 <= word.length, prefix.length <= 2000
// word 和 prefix 仅由小写英文字母组成
//  insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次

public class Trie_208_standard {

    private Trie_208_standard[] son = new Trie_208_standard[26];
    private boolean isEnd;

    public Trie_208_standard() {
    }

    public void insert(String word) {
        Trie_208_standard head = this;
        for (int i = 0; i < word.length(); i++) {
            char tmp = word.charAt(i);
            int index = tmp - 'a';
            if (head.son[index] == null) {
                head.son[index] = new Trie_208_standard();
            }
            head = head.son[index];
        }
        head.isEnd = true;
    }

    public Trie_208_standard coreSearch(String word) {
        Trie_208_standard head = this;
        for (int i = 0; i < word.length(); i++) {
            char tmp = word.charAt(i);
            int index = tmp - 'a';
            if (head.son[index] == null) {
                return null;
            }
            head = head.son[index];
        }
        return head;
    }

    public boolean search(String word) {
        Trie_208_standard node = coreSearch(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return coreSearch(prefix) != null;
    }

}
