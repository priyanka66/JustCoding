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
            if (node != null && root.val < node.val) return false;
            node = root;
            root = root.right;
//            if (root != null )
//                System.out.println("cur-- "+  root.val + " ");
        }

        return true;
    }
    public static void main(String[] args) {
        isValidBST b = new isValidBST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(6);
        System.out.print(b.isValidBST(root));
    }
}
