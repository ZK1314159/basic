package leetcode;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/6/17 20:08 <br>
 */

//树的节点数在 [1, 104] 范围内
//0 <= Node.val <= 104

public class Rob_337 {

    private Map<TreeNode, Integer> dpTrue = new HashMap<>();
    private Map<TreeNode, Integer> dpFalse = new HashMap<>();

    public int rob(TreeNode root) {
        return Math.max(rob(root, true), rob(root, false));
    }

    int rob(TreeNode node, boolean useNode) {
        if (node == null) {
            return 0;
        }
        if (useNode && dpTrue.get(node) != null) {
            return dpTrue.get(node);
        }
        if (!useNode && dpFalse.get(node) != null) {
            return dpFalse.get(node);
        }

        if (useNode) {
            int left = rob(node.left, false);
            int right = rob(node.right, false);
            int value = left + right + node.val;
            dpTrue.put(node, value);
            return value;
        }

        int value1 = Math.max(rob(node.left, false), rob(node.left, true));
        int value2 = Math.max(rob(node.right, false), rob(node.right, true));
        value1 += value2;
        dpFalse.put(node, value1);
        return value1;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3,2,3,null,3,null,1));
        TreeNode treeNode = TreeNodeUtil.buildTreeFormLayerScan(list);
        Rob_337 rob_337 = new Rob_337();
        int answer = rob_337.rob(treeNode);
    }

}
