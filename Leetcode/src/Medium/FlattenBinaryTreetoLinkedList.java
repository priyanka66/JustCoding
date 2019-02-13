package Medium;

public class FlattenBinaryTreetoLinkedList {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void flatten(TreeNode root) {
        if (root == null) return;

        flattenTree(root);
    }

    private TreeNode flattenTree(TreeNode root) {
        TreeNode left = root.left, right = root.right;
        if (root.left == null && root.right == null) return root;
        if (left != null) {
            TreeNode leaf = flattenTree(left);
            leaf.right = right;
            root.right = left;
            root.left = null;
            root = leaf;
        }
        if (right!= null) {
            return flattenTree(right);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        FlattenBinaryTreetoLinkedList l = new FlattenBinaryTreetoLinkedList();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        l.flattenTree(root);
        System.out.println(root);
    }
}
