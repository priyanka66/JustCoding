package Hard;

public class BinaryTreeMaximumPathSum {
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
    int maxValue;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxValue = Integer.MIN_VALUE;
        maxPathValue(root);
        return maxValue;
    }

    public int maxPathValue(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(maxPathValue(root.left), 0);
        int right  = Math.max(maxPathValue(root.right), 0);
        maxValue = Math.max(left+right+root.val, maxValue);
        return Math.max(left, right)+root.val;
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum p = new BinaryTreeMaximumPathSum();
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right= new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(p.maxPathSum(root));

    }
}
