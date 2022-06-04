package leetcode;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/6/4 10:22 <br>
 */
public class TreeNodeUtil {

    public static class TreeNodeObject {
        private TreeNode node;
        private int count;
        public TreeNodeObject(TreeNode node, int count) {
            this.node = node;
            this.count = count;
        }
    }

    public static TreeNode getBeforeOrderNodeById(TreeNode root, int position) {
        if (position == 0) {
            return null;
        }
        TreeNodeObject result = find(root, position);
        return result.node;
    }

    static TreeNodeObject find(TreeNode root, int position) {
        if (root == null) {
            return new TreeNodeObject(null, 0);
        }
        position--;
        if (position == 0) {
            return new TreeNodeObject(root, -1);
        }
        TreeNodeObject left = find(root.left, position);
        if (left.node != null) {
            return left;
        } else {
            position -= left.count;
        }
        TreeNodeObject right = find(root.right, position);
        if (right.node != null) {
            return right;
        }
        return new TreeNodeObject(null, left.count + right.count + 1);
    }

    public static TreeNode getLayerOrderNodeById(TreeNode root, int position) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (! deque.isEmpty()) {
           TreeNode node = deque.poll();
           position--;
           if (position == 0) {
               return node;
           } else {
               if (node.left != null) {
                   deque.offer(node.left);
               }
               if (node.right != null) {
                   deque.offer(node.right);
               }
           }
        }
        return null;
    }

}
