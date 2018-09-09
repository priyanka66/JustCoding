package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    private List<Integer> inOrderNodes(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        if (root == null) return nodes;
        Stack<TreeNode> st = new Stack<>();
        while (!st.isEmpty() || root!=null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            nodes.add(root.val);
            root = root.right;
        }
        return nodes;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(" " + root.val);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        InOrderTraversal i = new InOrderTraversal();
        TreeNode t1 = new TreeNode(10);
        t1.left = new TreeNode(2);
        t1.left.left = new TreeNode(6);
        t1.right = new TreeNode(5);
        t1.right.left = new TreeNode(8);
        t1.right.right = new TreeNode(3);

        i.inOrder(t1);
        System.out.println(" ");
        System.out.println(i.inOrderNodes(t1));

    }
}
