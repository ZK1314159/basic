package leetcode;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description：<br>
 * 20:03开始看题
 * 20:51写完答案
 * 21:34答案AC
 * 22:02最佳答案AC
 * CreateDate：2022/6/17 20:08 <br>
 */

//树的节点数在 [1, 104] 范围内
//0 <= Node.val <= 104

public class Rob_337_standard {

    public int rob(TreeNode root) {
        int[] answer = dfs(root);
        return Math.max(answer[0], answer[1]);
    }

    int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int useNode = node.val + left[1] + right[1];
        int notUseNode = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{useNode, notUseNode};
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3,2,3,null,3,null,1));
        TreeNode treeNode = TreeNodeUtil.buildTreeFormLayerScan(list);
        Rob_337_standard rob_337 = new Rob_337_standard();
        int answer = rob_337.rob(treeNode);
    }

}
