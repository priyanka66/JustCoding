package Easy;

import java.util.*;

public class DiameterOfBT {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    int diameter = 0;
    private int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        getHeight(root);
        return diameter;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        diameter = Math.max((left+right), diameter);
        return Math.max(left,right) +1;
    }

    private int diameterOfBinaryTreeV2(TreeNode root) {
        if (root == null) return 0;
        Map<TreeNode, Integer> lmap = new HashMap<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        int max = 0;
        while (!st.empty()) {
            TreeNode node = st.pop();
            if (node != null) {
                Integer left = lmap.get(node.left);
                Integer right = lmap.get(node.right);
                if (left != null && right!= null) {
                     lmap.put(node, Math.max(left, right)+1);
                     max = Math.max(max, (left+right));
                } else {
                    st.push(node);
                    st.push(node.right);
                    st.push(node.left);
                }
            } else {
                lmap.put(null,0);
            }
        }

        return max;

    }

    public static void main(String[] args) {
        DiameterOfBT d = new DiameterOfBT();
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left= new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode root1 = root;
        System.out.println(d.diameterOfBinaryTree(root));

        System.out.println(d.diameterOfBinaryTreeV2(root));
    }
}
