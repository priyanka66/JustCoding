package Medium;


import java.util.Stack;

public class isValidBST {
    public  static class TreeNode {
        int val;
        TreeNode left,right;
        TreeNode(int x ) {
            val=x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = null;
        while (!st.isEmpty() || root!=null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            System.out.println(root.val+ " ");
            if (node != null && root.val < node.val) return false;
            node = root;
            root = root.right;
        }

        return true;
    }

    public boolean isValidBSTV2(TreeNode root) {
        if (root ==  null) return true;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isValidBST(TreeNode root, long min, long max) {
        System.out.println(Long.MAX_VALUE);
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);

    }
    public static void main(String[] args) {
        isValidBST b = new isValidBST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        System.out.print(b.isValidBST(root));
        System.out.print(b.isValidBSTV2(root));
    }
}
