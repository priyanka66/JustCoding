package Medium;

import jdk.nashorn.api.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthofBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        root.val = 0;
        int max = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            max = Math.max(queue.peekLast().val - queue.peekFirst().val+1, max);
            for (int i=0;i<size;i++) {
                root = queue.poll();
                if (root.left != null) {
                    root.left.val = (root.val * 2);
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    root.right.val = (root.val * 2) +1;
                    queue.offer(root.right);
                }
            }

        }

        return max;
    }

    public static void main(String[] args) {
        MaximumWidthofBinaryTree b = new MaximumWidthofBinaryTree();
        TreeNode root  = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(b.widthOfBinaryTree(root));

    }
}
