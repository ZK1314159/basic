package leetcode;

import tree.TreeNode;

/**
 * Description：<br>
 * 10:10 开始读题
 * 10:17 想到解法
 * 10:35 写完解法
 * 10:35 解法AC
 * CreateDate：2022/4/15 10:17 <br>
 */
public class MergeTrees_617_New {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null) {
            root1.val += root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        }
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root2 != null) {
            return root2;
        }
        return root1;
    }

}
