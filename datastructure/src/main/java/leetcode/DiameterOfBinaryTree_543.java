package leetcode;

import tree.TreeNode;

/**
 * Description：<br>
 * 9:33开始看题
 * 9:42 想到解法
 * 9:50 写完解法
 * 9:59 解法AC
 * CreateDate：2022/4/15 9:43 <br>
 */
public class DiameterOfBinaryTree_543 {

    private int answer;

    public int diameterOfBinaryTree(TreeNode root) {
        recursive(root);
        return answer;
    }

    int recursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recursive(root.left);
        int right = recursive(root.right);
        int sum = left + right;
        if (sum > answer) {
            answer = sum;
        }
        return Math.max(left, right) + 1;
    }

}
