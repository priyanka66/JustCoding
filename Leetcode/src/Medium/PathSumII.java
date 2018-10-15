package Medium;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int x) {
            val=x;
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;

        List<Integer> temp = new ArrayList<>();

        dfs(root, sum, result, temp);

        return result;
    }

    void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> temp) {
        if (root == null) return;

        temp.add(root.val);
        if (root.val == sum && root.left==null && root.right == null) {
            result.add(new ArrayList<>(temp));
        }
        dfs(root.left, sum-root.val, result, temp);
        dfs(root.right, sum-root.val, result, temp);

        temp.remove(temp.size()-1);
    }

    public static void main(String[] args) {
        PathSumII i = new PathSumII();
        TreeNode t1 = new TreeNode(5);
        t1.left = new TreeNode(4);
        t1.right = new TreeNode(8);
        t1.left.left = new TreeNode(11);
        t1.left.left.left = new TreeNode(7);
        t1.left.left.right = new TreeNode(2);
        t1.right.left = new TreeNode(13);
        t1.right.right = new TreeNode(4);
        t1.right.right.left = new TreeNode(5);
        t1.right.right.right = new TreeNode(1);


        int sum = 22;
        System.out.println(i.pathSum(t1, sum));

    }
}
