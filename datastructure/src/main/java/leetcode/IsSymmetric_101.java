package leetcode;

import tree.TreeNode;

/**
 * Description：<br>
 * 21:30开始看题
 * 21:33 想到算法
 * 21:39 写完算法
 * 21:47 算法AC
 * 21:48 官方算法AC
 * CreateDate：2022/3/15 21:33 <br>
 */
public class IsSymmetric_101 {

    public boolean isSymmetric(TreeNode root) {
        return recursive(root.left, root.right);
    }
    
    boolean recursive(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            if (left.val == right.val) {
                return recursive(left.left, right.right) && recursive(left.right, right.left);
            }
            return false;
        }
        return false;
    }

}
