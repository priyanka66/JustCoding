package Medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        rightSideView(root, result, 0);
        return result;
    }

    void rightSideView(TreeNode root, List<Integer> result, int depth) {
        if (root == null) return;
        if (result.size() == depth) result.add(root.val);
        rightSideView(root.right, result, depth+1);
        rightSideView(root.left, result, depth+1);
    }

    public static void main(String[] args) {
        BinaryTreeRightSideView t = new BinaryTreeRightSideView();
        TreeNode root = new TreeNode(1);
        root.left =  new TreeNode(2);
        root.right =  new TreeNode(3);
        root.left.right =  new TreeNode(5);
//        root.right.right =  new TreeNode(4);
        System.out.println(t.rightSideView(root));
    }
}
