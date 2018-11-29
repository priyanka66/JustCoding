package Easy;

import java.util.*;
public class PathSumIII {
    public static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int x) {
            val=x;
        }
    }

    private int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root,sum) + pathSum(root.left,sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }

    int count = 0;
    private int pathSumV2(TreeNode root, int sum) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            findPath(node, 0, sum);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return count;
    }

    void findPath(TreeNode node, int sum, int target) {
        if (node == null) return;
        sum += node.val;
        if (sum == target) count++;
        findPath(node.left, sum, target);
        findPath(node.right, sum, target);

    }
    public static void main(String[] args) {
        PathSumIII i = new PathSumIII();
        TreeNode t1 = new TreeNode(10);
        t1.left = new TreeNode(5);
        t1.right = new TreeNode(-3);
        t1.left.left = new TreeNode(3);
        t1.left.right = new TreeNode(2);
        t1.right.right = new TreeNode(11);
        t1.left.left.left = new TreeNode(3);
        t1.left.left.right = new TreeNode(-2);
        t1.left.right.left = new TreeNode(1);

        int sum = 8;
        System.out.println(i.pathSum(t1, sum));
        System.out.println(i.pathSumV2(t1, sum));

    }
}
