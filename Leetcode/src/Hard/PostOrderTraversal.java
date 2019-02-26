package Hard;

import java.util.*;

public class PostOrderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        if (root == null) return nodes;
        Stack<TreeNode> st1 = new Stack<>();
        st1.add(root);
        while (!st1.isEmpty()) {
            TreeNode node = st1.pop();
            nodes.add(0,node.val);
            if (node.left != null) st1.add(node.left);
            if (node.right != null) st1.add(node.right);
        }

        return nodes;
    }

    public static void main(String[] args) {
        PostOrderTraversal p = new PostOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right= new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(p.postorderTraversal(root));

    }
}
