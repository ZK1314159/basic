package leetcode;

import tree.TreeNode;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/3/1 11:21 <br>
 */
public class BuildTreeFromForwardAndMiddleScan {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        // 找到最左节点和根节点
        TreeNode root = new TreeNode(preorder[0]);
        int inRoot = findFromIn(root.val, inorder);

        // 构造一个基本的三角节点
        if (inRoot >= 1) {
            root.left = new TreeNode(preorder[1]);
        }
        if (inRoot < inorder.length - 1) {
            int leftNumber = inRoot;
            int position = leftNumber + 1;
            root.right = new TreeNode(preorder[position]);
        }
        
        if (root.left != null) {
            leftFindSon(root.left, 0, inRoot - 1, findFromIn(root.left.val, inorder), inRoot, inorder, 1, preorder);
        }
        if (root.right != null) {
            rightFindSon(root.right, inRoot + 1, inorder.length - 1, findFromIn(root.right.val, inorder), inRoot,
                    inorder, inRoot + 1, preorder);
        }
        
        return root;
    }
    
    public void leftFindSon(TreeNode node, int inStart, int inEnd, int inNode, int inFather, int[] inorder, int preNode,
                            int[] preorder) {
        // 有左节点
        if (inNode > inStart) {
            node.left = new TreeNode(preorder[preNode + 1]);
            leftFindSon(node.left, inStart, inNode - 1, findFromIn(node.left.val, inorder), inNode, inorder,
                    preNode + 1, preorder);
        }
        // 有右节点
        if (inNode < inEnd) {
            int leftNumber = inNode - inStart;
            int position = preNode + leftNumber + 1;
            node.right = new TreeNode(preorder[position]);
            rightFindSon(node.right, inNode + 1, inFather - 1, findFromIn(node.right.val, inorder), inNode, inorder,
                    position, preorder);
        }
    }

    public void rightFindSon(TreeNode node, int inStart, int inEnd, int inNode, int inFather, int[] inorder,
                             int preNode, int[] preorder) {
        // 有左节点
        if (inNode > inStart) {
            node.left = new TreeNode(preorder[preNode + 1]);
            leftFindSon(node.left, inFather + 1, inNode - 1, findFromIn(node.left.val, inorder), inNode, inorder,
                    preNode + 1, preorder);
        }
        // 有右节点
        if (inNode < inEnd) {
            int leftNumber = inNode - inStart;
            int position = preNode + leftNumber + 1;
            node.right = new TreeNode(preorder[position]);
            rightFindSon(node.right, inNode + 1, inEnd, findFromIn(node.right.val, inorder), inNode, inorder, position,
                    preorder);
        }
    }
    
    public int findFromIn(int value, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (value == inorder[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};
        BuildTreeFromForwardAndMiddleScan test = new BuildTreeFromForwardAndMiddleScan();
        TreeNode treeNode = test.buildTree(preorder, inorder);
    }

}
