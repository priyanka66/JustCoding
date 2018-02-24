public class MinDepth {

    public int minDepth(SymmetricTree.TreeNode p) {
        if (p == null) return 0;
        int minDepth;
        int rightDepth = minDepth(p.right);
        int leftDepth = minDepth(p.left);

        if (rightDepth ==0 || leftDepth ==0) {
            return  leftDepth + rightDepth+1;
        }
        else return Math.min(leftDepth, rightDepth) +1;

    }
    public static void main(String[] args) {
        MinDepth d = new MinDepth();
        SymmetricTree.TreeNode p = new SymmetricTree.TreeNode(1);
        p.left = new SymmetricTree.TreeNode(2);
//        p.right = new SymmetricTree.TreeNode(2);
//        p.left.left = new SymmetricTree.TreeNode(3);
//        p.left.right = new SymmetricTree.TreeNode(3);
//        p.right.left = new SymmetricTree.TreeNode(2);

        int depth = d.minDepth(p);
        System.out.println("Min Depth : " + depth);

    }
}
