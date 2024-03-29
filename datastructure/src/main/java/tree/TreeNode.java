package tree;

/**
 * Description：<br>
 * <br>
 * CreateDate：2022/2/28 20:22 <br>
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object anObject) {
        return this.val == ((TreeNode) anObject).val;
    }

    @Override
    public int hashCode() {
        return this.val;
    }

    @Override
    public String toString() {
        return "val: " + val;
    }

 }
