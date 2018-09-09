package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElementBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }


    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        int result = root.val;
        if (root == null) return -1;
        Stack<TreeNode> st = new Stack<>();
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }


            root = st.pop();
            result = root.val;
            k--;
            if (k == 0 || st.isEmpty()) return result;
            res.add(root.val);
            root = root.right;
        }

        System.out.println(res);

        return -1;
    }

    public static void main(String[] args) {
        KthSmallestElementBST b = new KthSmallestElementBST();
        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(1);
//        root.left.right = new TreeNode(2);
//        root.right = new TreeNode(4);

        System.out.println(b.kthSmallest(root, 1));
    }
}
