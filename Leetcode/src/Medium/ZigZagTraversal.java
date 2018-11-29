package Medium;
import java.util.*;

public class ZigZagTraversal {
    public static class TreeNode {
        int val;
        TreeNode left,right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> st1 = new Stack();
        Stack<TreeNode> st2 = new Stack();
        st1.push(root);
        while (!st1.empty() || !st2.empty()) {
            List<Integer> res1 = new ArrayList<>();
            while (!st1.empty()) {
                TreeNode node = st1.pop();
                res1.add(node.val);
                if (node.left!=null) st2.push(node.left);
                if (node.right!=null) st2.push(node.right);
            }
            if (!res1.isEmpty()) result.add(res1);
            List<Integer> res2 = new ArrayList<>();
            while (!st2.empty()) {
                TreeNode node = st2.pop();
                res2.add(node.val);
                if (node.right!=null) st1.push(node.right);
                if (node.left!=null) st1.push(node.left);
            }
            if (!res2.isEmpty()) result.add(res2);

        }

        return result;

    }
    public static void main(String[] args) {
        ZigZagTraversal z = new ZigZagTraversal();
        TreeNode t1 = new TreeNode(10);
        t1.left = new TreeNode(2);
        t1.left.left = new TreeNode(6);
        t1.right = new TreeNode(5);
        t1.right.left = new TreeNode(8);
        t1.right.right = new TreeNode(3);

        System.out.println(z.zigzagLevelOrder(t1));
    }
}
