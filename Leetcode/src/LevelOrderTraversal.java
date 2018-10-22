import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int x) {
            val = x;
        }
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (!q1.isEmpty()) {
                List<Integer> temp = new ArrayList<>();
                while (!q1.isEmpty()) {
                    TreeNode node = q1.poll();
                    temp.add(node.val);
                    if(node.left != null) q2.add(node.left);
                    if(node.right != null) q2.add(node.right);
                }
                result.add(temp);
            } else {
                List<Integer> temp = new ArrayList<>();
                while (!q2.isEmpty()) {
                    TreeNode node = q2.poll();
                    temp.add(node.val);
                    if(node.left != null) q1.add(node.left);
                    if(node.right != null) q1.add(node.right);
                }
                result.add(temp);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        LevelOrderTraversal l = new LevelOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left= new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left= new TreeNode(15);
        root.right.right = new TreeNode(7);

        TreeNode root1 = root;
        System.out.println(l.levelOrder(root));

    }
}
