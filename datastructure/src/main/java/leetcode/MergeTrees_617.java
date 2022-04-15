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
public class MergeTrees_617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        recursive(root1, root2, null, true);
        if (root1 != null) {
            return root1;
        } else {
            return root2;
        }
    }

    void recursive(TreeNode root1, TreeNode root2, TreeNode father, boolean isLeft) {
        if (root1 == null && root2 == null) {
            return;
        }
        if (root1 != null && root2 != null) {
            root1.val += root2.val;
            recursive(root1.left, root2.left, root1, true);
            recursive(root1.right, root2.right, root1, false);
        } else if (root2 != null) {
            if (father != null) {
                if (isLeft) {
                    father.left = root2;
                } else {
                    father.right = root2;
                }
            }
        }
    }

}
