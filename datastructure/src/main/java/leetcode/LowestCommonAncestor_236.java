package leetcode;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/6/4 9:28 <br>
 */

//        树中节点数目在范围 [2, 105] 内。
//        -109 <= Node.val <= 109
//        所有 Node.val 互不相同 。
//        p != q
//        p 和 q 均存在于给定的二叉树中。

public class LowestCommonAncestor_236 {

    private List<TreeNode> history = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        record(root, p);
        for (int i = 0; i < history.size(); i++) {
            TreeNode tmp = history.get(i);
            if (tmp == q) {
                return tmp;
            } else {
                TreeNode node;
                if (i > 0) {
                    if (history.get(i - 1) == history.get(i).left) {
                        node = history.get(i).right;
                    } else {
                        node = history.get(i).left;
                    }
                } else {
                    node = tmp;
                }
                if (contains(node, q)) {
                    return tmp;
                }
            }
        }
        return null;
    }

    boolean record(TreeNode head, TreeNode target) {
        if (head == null) {
            return false;
        }
        if (head == target) {
            history.add(head);
            return true;
        }
        if (record(head.left, target)) {
            history.add(head);
            return true;
        }
        if (record(head.right, target)) {
            history.add(head);
            return true;
        }
        return false;
    }

    boolean contains(TreeNode head, TreeNode target) {
        if (head == null) {
            return false;
        }
        if (head == target) {
            return true;
        }
        if (contains(head.left, target)) {
            return true;
        }
        return contains(head.right, target);
    }

    public static void main(String[] args) {
        BuildTreeFromForwardAndMiddleScan_Standard util = new BuildTreeFromForwardAndMiddleScan_Standard();
        int[] preorder = new int[] {3, 5, 6, 2, 7, 4, 1, 0, 8};
        int[] inorder = new int[] {6, 5, 7, 2, 4, 3, 0, 1, 8};
        TreeNode tree = util.buildTree(preorder, inorder);
        LowestCommonAncestor_236 test = new LowestCommonAncestor_236();
        TreeNode p = TreeNodeUtil.getLayerOrderNodeById(tree, 2);
        TreeNode q = TreeNodeUtil.getLayerOrderNodeById(tree, 9);
        TreeNode answer = test.lowestCommonAncestor(tree, p, q);
    }

}
