package leetcode;

import tree.TreeNode;

/**
 * Description：<br>
 * 16:17开始读题
 * 16:22 想到算法
 * 16:27 写完算法
 * 16:27 算法AC
 * 16:28 官方算法AC
 * CreateDate：2022/3/23 16:23 <br>
 */
public class InvertTree_226 {

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invert(root.left);
        invert(root.right);
    }

}
