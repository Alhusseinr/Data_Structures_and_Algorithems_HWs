package ds;

public class BinarySearchTree {
    public TreeNode root;

    public BinarySearchTree () {
        root = null;
    }

    public void inorder_tree_walk (TreeNode x) {
        if(x != null){
            inorder_tree_walk (x.left);
            System.out.println(x.key);
            inorder_tree_walk (x.right);
        }
    }

    public TreeNode search (TreeNode x, int k) {
        if(x == null || k == x.key){
            return x;
        }
        if(k < x.key){
            return search(x.left, k);
        }else{
            return search(x.right, k);
        }
    }

    public TreeNode iterative_search (TreeNode x,int k) {
        while(x != null && k != x.key){
            if(k < x.key){
                x = x.left;
            }else{
                x = x.right;
            }
        }
        return x;
    }

    public TreeNode minimum () {
        while (root.left != null){
            root = root.left;
        }
        return root;
    }

    public TreeNode maximum () {
        while(root.right != null){
            root = root.right;
        }
        return root;
    }

    public TreeNode successor (TreeNode x) {
        if(x.right != null){
            return minimum();
        }
        root = x.p;
        while (root != null && x == root.right){
            x = root;
            root = root.p;
        }
        return root;
    }

    public void insert (int i) {
        TreeNode x = root;
        while(x != null){
            root = x;
            if(x.key < x.key){
                x = x.left;
            }else{
                x = x.right;
            }
        }
        x.p = root;
        if(root == null){
            root = x;
        }else if(x.key < root.key){
            root.left = x;
        }else{
            root.right = x;
        }
    }

    private void PostOrder(TreeNode x){
        if(x == null)
            return;
        PostOrder(x.left);
        PostOrder(x.right);
        System.out.println("Post Order:" + x.left + x.right);
    }

    private void PreOrder(TreeNode x){
        if(x == null)
            return;
        PostOrder(x.right);
        PostOrder(x.left);
        System.out.println("Post Order:" + x.right + x.left);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
        BinarySearchTree bst;
        TreeNode n;

        bst = new BinarySearchTree();
        for (int i = 0; i < array.length; i++)
            bst.insert(array[i]);

        System.out.println("Inorder_tree_walk starts ------------------");
        bst.inorder_tree_walk(bst.root);
        System.out.println("Inorder_tree_walk ends ------------------");
        System.out.print("\n\n");

        System.out.println("Search starts ------------------");
        n = bst.search(bst.root, 13);
        System.out.println("found: " + n.key);
        System.out.println("Search ends ------------------");
        System.out.print("\n\n");

        System.out.println("Iterative search starts ------------------");
        n = bst.iterative_search(n,4);
        System.out.println("found: " + n.key);
        System.out.println("Iterative search ends ------------------");
        System.out.print("\n\n");

        System.out.println("Minimum starts ------------------");
        n = bst.minimum();
        System.out.println("Minimum key is " + n.key);
        System.out.println("Minimum ends ------------------");
        System.out.print("\n\n");

        System.out.println("Maximum starts ------------------");
        n = bst.maximum();
        System.out.println("Maximum key is " + n.key);
        System.out.println("Maximum ends ------------------");
        System.out.print("\n\n");

        System.out.println("Successor starts ------------------");
        n = bst.successor(bst.root.left.right.right);
        System.out.println("Successor key is " + n.key);
        System.out.println("Successor ends ------------------");
        System.out.print("\n\n");
    }

}