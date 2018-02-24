public class SumPath {

    public boolean hasPathSum(SymmetricTree.TreeNode root, int sum) {
        if (root == null) return false;
        else {
            int nodeVal = sum - root.val;
            boolean hasPath = false;
            if (nodeVal == 0 && root.left == null && root.right == null) return true;
            if (root.left != null) hasPath = hasPath || hasPathSum(root.left, nodeVal);
            if (root.right != null) hasPath = hasPath || hasPathSum(root.right, nodeVal);

            return hasPath;
        }
    }
    public static void main(String[] args) {
        SymmetricTree s1 = new SymmetricTree();
        SymmetricTree.TreeNode p = new SymmetricTree.TreeNode(5);
        SumPath s2 = new SumPath();
        p.left = new SymmetricTree.TreeNode(4);
        p.right = new SymmetricTree.TreeNode(8);
        p.left.left = new SymmetricTree.TreeNode(11);
//        p.left.right = new SymmetricTree.TreeNode();
        p.left.left.left = new SymmetricTree.TreeNode(7);
        p.left.left.right = new SymmetricTree.TreeNode(2);
        p.right.left = new SymmetricTree.TreeNode(13);
        p.right.right = new SymmetricTree.TreeNode(4);
        p.right.right.right = new SymmetricTree.TreeNode(1);
        int sum = 22;

        if(s2.hasPathSum(p, sum)) System.out.println("YES");
        else System.out.println("NO");


    }
}
