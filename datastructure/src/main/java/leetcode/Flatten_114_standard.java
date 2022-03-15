package leetcode;

import tree.TreeNode;

/**
 * Description：<br>
 * 22:01 开始看题
 * 22:10 想到算法
 * 22:28 写完算法
 * 22:28 算法AC
 * 官方算法用的循环，看起来头疼，但思想是一样的
 * CreateDate：2022/3/15 22:11 <br>
 */
public class Flatten_114_standard {

    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }

}
