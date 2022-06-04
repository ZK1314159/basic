package leetcode;

import tree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description：<br>
 * 9:20 开始读题
 * 9:27 想到解法
 * 9:59 写完解法
 * CreateDate：2022/6/4 9:28 <br>
 */

//        树中节点数目在范围 [2, 105] 内。
//        -109 <= Node.val <= 109
//        所有 Node.val 互不相同 。
//        p != q
//        p 和 q 均存在于给定的二叉树中。

public class LowestCommonAncestor_236_standard {

    private Set<Integer> history = new HashSet<>();
    private Map<Integer, TreeNode> fatherMap = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        search(null, root, p.val, q.val);
        while (p != null) {
            history.add(p.val);
            p = fatherMap.get(p.val);
        }
        while (q != null) {
            if (history.contains(q.val)) {
                return q;
            }
            q = fatherMap.get(q.val);
        }
        return null;
    }

    void search(TreeNode father, TreeNode node, Integer p, Integer q) {
        if (node == null) {
            return;
        }
        if (fatherMap.containsKey(p) && fatherMap.containsKey(q)) {
            return;
        }
        fatherMap.put(node.val, father);
        search(node, node.left, p, q);
        search(node, node.right, p, q);
    }

    public static void main(String[] args) {
        BuildTreeFromForwardAndMiddleScan_Standard util = new BuildTreeFromForwardAndMiddleScan_Standard();
        int[] preorder = new int[] {3, 5, 6, 2, 7, 4, 1, 0, 8};
        int[] inorder = new int[] {6, 5, 7, 2, 4, 3, 0, 1, 8};
        TreeNode tree = util.buildTree(preorder, inorder);
        LowestCommonAncestor_236_standard test = new LowestCommonAncestor_236_standard();
        TreeNode p = TreeNodeUtil.getLayerOrderNodeById(tree, 2);
        TreeNode q = TreeNodeUtil.getLayerOrderNodeById(tree, 3);
        TreeNode answer = test.lowestCommonAncestor(tree, p, q);
    }

}
