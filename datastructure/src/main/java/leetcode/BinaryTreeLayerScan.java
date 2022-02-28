package leetcode;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/2/28 20:24 <br>
 */
public class BinaryTreeLayerScan {

    public static class NodeAndLayer {
        public TreeNode treeNode;
        public int layer;
        public NodeAndLayer(TreeNode treeNode, int layer) {
            this.treeNode = treeNode;
            this.layer = layer;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<NodeAndLayer> deque = new ArrayDeque<>();
        deque.offer(new NodeAndLayer(root, 0));
        int currentLayer = 0;
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        while (! deque.isEmpty()) {
            NodeAndLayer nodeAndLayer = deque.poll();
            int layer = nodeAndLayer.layer;
            TreeNode node = nodeAndLayer.treeNode;
            if (layer > currentLayer) {
                lists.add(new ArrayList<>(tmp));
                tmp.clear();
                currentLayer = layer;
                tmp.add(node.val);
            } else {
                tmp.add(node.val);
            }
            if (node.left != null) {
                deque.offer(new NodeAndLayer(node.left, layer + 1));
            }
            if (node.right != null) {
                deque.offer(new NodeAndLayer(node.right, layer + 1));
            }
        }
        lists.add(tmp);

        return lists;
    }

}
