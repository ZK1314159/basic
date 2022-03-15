package leetcode;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/15 17:22 <br>
 */
public class InorderTraversal_94 {

    private List<Integer> answer = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return answer;
        }
        recursive(root);

        return answer;
    }

    public void recursive(TreeNode father) {
        if (father.left != null) {
            recursive(father.left);
        }
        answer.add(father.val);
        if (father.right != null) {
            recursive(father.right);
        }
    }

}

