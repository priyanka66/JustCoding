package Easy;

public class BalancedTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.abs(left-right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    int getHeight(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left,right) +1;
    }
    public static void main(String[] args) {
        BalancedTree t = new BalancedTree();
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(2);
        p.left.left = new TreeNode(3);
        p.left.right = new TreeNode(3);
        p.left.left.left = new TreeNode(3);
        p.left.left.right = new TreeNode(3);

        System.out.println(t.isBalanced(p));
    }
}
