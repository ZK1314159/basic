package leetcode;

import tree.TreeNode;

/**
 * Description：<br>
 * 19:56 开始看题
 * 20:11 想到算法
 * 20:21 写完算法
 * 20:51 算法AC
 * 20:51 官方算法AC
 * CreateDate：2022/3/15 20:12 <br>
 */
public class IsValidBST_98 {

    public boolean isValidBST(TreeNode root) {
        return recursive(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }

    boolean recursive(long start, long end, TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val < start || root.val > end) {
            return false;
        }
        boolean leftValid = recursive(start, (long)root.val - 1, root.left);
        if (!leftValid) {
            return false;
        }
        return recursive((long)root.val + 1, end, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        root.left = new TreeNode(Integer.MIN_VALUE);
        IsValidBST_98 test = new IsValidBST_98();
        boolean answer = test.isValidBST(root);
    }

}
