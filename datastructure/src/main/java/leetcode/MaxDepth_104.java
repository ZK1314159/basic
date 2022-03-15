package leetcode;

import tree.TreeNode;

/**
 * Description：<br>
 * 21:50 开始看题
 * 21:51 想到算法
 * 21:58 写完算法
 * 21:58 算法AC
 * 22:00 官方算法AC
 * CreateDate：2022/3/15 21:52 <br>
 */
public class MaxDepth_104 {

    int max;

    public int maxDepth(TreeNode root) {
        measure(root, 0);
        return max;
    }

    void measure(TreeNode root, int depth) {
        if (root != null) {
            max = Math.max(max, depth + 1);
        } else {
            return;
        }
        measure(root.left, depth + 1);
        measure(root.right, depth + 1);
    }

}
