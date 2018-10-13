public class TrimBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode trimBST(TreeNode root, int L, int R){
        if (root == null) return root;
        if (root.val >= L && root.val <=R) {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);

            return root;
        } else if (root.val < L) {
            root.right = trimBST(root.right, L, R);
            return root.right;
        } else {
            root.left = trimBST(root.left, L, R);
            return root.left;
        }
    }

    private TreeNode trimBSTV2(TreeNode root, int L, int R){
        if (root == null) return null;

        while (root.val < L || root.val > R) {
            if (root.val < L) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        TreeNode node = root;
        while (node != null) {
            while (node.left != null && node.left.val < L) {
                node.left = node.left.right;
            }
            node = node.left;
        }

        node = root;
        while (node != null) {
            while (node.right != null && node.right.val > R) {
                node.right = node.right.left;
            }

            node = node.right;
        }

        return root;
    }
    public static void main(String[] args) {
        TrimBST t = new TrimBST();
        TreeNode root = new TreeNode(3);
        root.left= new TreeNode(0);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        TreeNode root1 = root;
        int L = 1, R=3;
        TreeNode result = t.trimBST(root, L, R);
        result = t.trimBSTV2(root, L, R);
        System.out.println("DOne");
    }
}
