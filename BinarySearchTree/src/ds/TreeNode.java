package ds;

public class TreeNode {
    public int key;
    public TreeNode p;
    public TreeNode left;
    public TreeNode right;

    public TreeNode () {
        p = left = right = null;
    }

    public TreeNode (int k) {
        key = k;
        p = left = right = null;
    }
}