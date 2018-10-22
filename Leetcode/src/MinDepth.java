public class MinDepth {

    public int minDepth(SymmetricTree.TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        // A leaf is a node with no children.
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);
        // Only do Math.min() if root has two children.
        return 1 + Math.min(minDepth(root.left),minDepth(root.right));
    }
    public static void main(String[] args) {
        MinDepth d = new MinDepth();
        SymmetricTree.TreeNode p = new SymmetricTree.TreeNode(1);
        p.left = new SymmetricTree.TreeNode(2);
//        p.right = new SymmetricTree.TreeNode(2);
//        p.left.left = new SymmetricTree.TreeNode(3);
//        p.left.right = new SymmetricTree.TreeNode(3);
//        p.left.right.right = new SymmetricTree.TreeNode(3);
//        p.left.right.right.right = new SymmetricTree.TreeNode(3);


//        p.right.left = new SymmetricTree.TreeNode(2);

        int depth = d.minDepth(p);
        System.out.println("Min Depth : " + depth);

    }
}
