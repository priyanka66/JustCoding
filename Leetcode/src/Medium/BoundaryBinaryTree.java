package Medium;

import java.util.*;

public class BoundaryBinaryTree {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    List<Integer> nodes = new ArrayList<>(1000);
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        if(root == null) return nodes;

        nodes.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);

        return nodes;
    }
    public void leftBoundary(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return;
        nodes.add(root.val);
        if(root.left == null) leftBoundary(root.right);
        else leftBoundary(root.left);
    }
    public void rightBoundary(TreeNode root) {
        if(root == null || (root.right == null && root.left == null)) return;
        if(root.right == null)rightBoundary(root.left);
        else rightBoundary(root.right);
        nodes.add(root.val); // add after child visit(reverse)
    }
    public void leaves(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            nodes.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }

    public static void main(String[] args) {
        BoundaryBinaryTree b = new BoundaryBinaryTree();
        TreeNode root  = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        root.right.left= new TreeNode(6);
        root.right.left.left= new TreeNode(9);
        root.right.left.right = new TreeNode(10);
        System.out.println(b.boundaryOfBinaryTree(root));

    }
}
