package leetcode;

import tree.TreeNode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/15 22:11 <br>
 */
public class Flatten_114 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        recursive(root);
    }

    TreeNode recursive(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        if (root.left != null && root.right != null) {
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode tail = recursive(root.right);
            tail.right = tmp;
            return recursive(tmp);
        }
        if (root.left != null) {
            root.right = root.left;
            root.left = null;
            return recursive(root.right);
        }
        return recursive(root.right);
    }

}
