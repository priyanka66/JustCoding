package Easy;

import java.util.*;

public class LevelOrderBottomUp {
    public static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private  List<Integer> levelOrderBottom(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<Integer> st = new Stack<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node.right != null) que.add(node.right);
            if (node.left != null) que.add(node.left);
            st.add(node.val);
        }

        List<Integer> temp = new ArrayList<>();
        while (!st.empty()) {
           result.add(st.pop());
        }

        return result;
    }

    public List<List<Integer>> levelOrderBottomV2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        dfs(root, result, 0);
        return result;
    }

    void dfs(TreeNode root,  List<List<Integer>> result, int depth) {
        if (root == null) return;
        if (result.size() <= depth) {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            result.add(0,temp);
        } else {

            result.get(result.size()-1-depth).add(root.val);
        }

        dfs(root.left, result, depth+1);
        dfs(root.right, result, depth+1);
    }


    public static void main(String[] args) {
        LevelOrderBottomUp l = new LevelOrderBottomUp();
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left= new TreeNode(4);
        root.right.right = new TreeNode(5);

        TreeNode root1 = root;
        System.out.println(l.levelOrderBottom(root));
        System.out.println(l.levelOrderBottomV2(root));

    }
}
