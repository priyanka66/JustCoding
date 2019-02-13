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
        rightSideView(root,0 , result);
        return result;
    }

    public void rightSideView(TreeNode root, int depth, List<Integer> result) {
        if (root == null) return;
        if (result.size() == depth) {
            result.add(root.val);
        }
        rightSideView(root.right, depth+1, result);
        rightSideView(root.left, depth+1, result);
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
