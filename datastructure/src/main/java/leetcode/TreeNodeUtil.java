package leetcode;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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

    public static TreeNode buildTreeFormLayerScan(List<Integer> nodeList) {
        if (nodeList == null || nodeList.size() == 0) {
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode root = new TreeNode(nodeList.get(0));
        TreeNode start;
        deque.offer(root);
        int position = 1;
        while (! deque.isEmpty()) {
            start = deque.poll();
            if (start == null) {
                continue;
            }
            if (position > nodeList.size() - 1) {
                break;
            }
            Integer left = nodeList.get(position);
            if (left != null) {
                start.left = new TreeNode(left);
                deque.offer(start.left);
            }
            position++;
            if (position > nodeList.size() - 1) {
                break;
            }
            Integer right = nodeList.get(position);
            if (right != null) {
                start.right = new TreeNode(right);
                deque.offer(start.right);
            }
            position++;
        }
        return root;
    }

}
