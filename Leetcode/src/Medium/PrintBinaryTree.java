package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintBinaryTree {


    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> result = new ArrayList<>();
        if (root == null) return result;
        int height = getHeight(root);
        int len = (int)Math.pow(2, height) - 1;
        String[] temp = new String[len];
        Arrays.fill(temp, "");
        return printTree(root, temp, result, len/2, 0, len, 0);

    }

    List<List<String>> printTree(TreeNode root, String[] temp, List<List<String>> result, int index, int start, int end, int depth) {
        if (root == null) return result;
        if (result.size() == depth)
            result.add(new ArrayList<String>(Arrays.asList(temp)));
        result.get(depth).set(index, root.val+"");
        printTree(root.left, temp, result, (start+index)/2, start, index, depth+1);
        printTree(root.right, temp, result, (end+index)/2, index,end, depth+1);
        return result;

    }

    int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left)+1, getHeight(root.right)+1);
    }

    public static void main(String[] args) {
        PrintBinaryTree b = new PrintBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(b.printTree(root));
    }
}
