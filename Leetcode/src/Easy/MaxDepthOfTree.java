package Easy;

public class MaxDepthOfTree {

    public int getMaxDepth(SymmetricTree.TreeNode p) {
        if (p == null) return 0;
        int rightDepth = getMaxDepth(p.right);
        int leftDepth = getMaxDepth(p.left);


        return Math.max(rightDepth, leftDepth) +1;
    }
    public static void main(String[] args) {
        MaxDepthOfTree d = new MaxDepthOfTree();
        SymmetricTree.TreeNode p = new SymmetricTree.TreeNode(1);
        p.left = new SymmetricTree.TreeNode(2);
        p.right = new SymmetricTree.TreeNode(2);
        p.left.left = new SymmetricTree.TreeNode(3);
        p.left.right = new SymmetricTree.TreeNode(3);
        p.right.left = new SymmetricTree.TreeNode(2);
        p.right.left.left= new SymmetricTree.TreeNode(2);


        int depth = d.getMaxDepth(p);
        System.out.println("Depth : " + depth);

    }
}
