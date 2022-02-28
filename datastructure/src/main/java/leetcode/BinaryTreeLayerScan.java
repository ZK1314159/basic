package leetcode;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/2/28 20:24 <br>
 */
public class BinaryTreeLayerScan {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        List<List<Integer>> lists = new ArrayList<>();
        while (! deque.isEmpty()) {
            int currentSize = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = deque.poll();
                if (node != null) {
                    list.add(node.val);
                    if (node.left != null) {
                        deque.offer(node.left);
                    }
                    if (node.right != null) {
                        deque.offer(node.right);
                    }
                }
            }
            lists.add(list);
        }

        return lists;
    }

}
