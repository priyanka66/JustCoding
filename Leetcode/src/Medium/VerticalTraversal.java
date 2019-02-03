package Medium;

import java.util.*;

public class VerticalTraversal {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
            left=null;
            right = null;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, Integer> distance = new HashMap<>();
        TreeMap<Integer, List<Integer>> hmap = new TreeMap<>();

        queue.add(root);
        distance.put(root, 0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int dist = distance.get(node);
            if (node.left != null) {
                queue.add(node.left);
                distance.put(node.left, dist-1);
            }

            if (node.right != null) {
                queue.add(node.right);
                distance.put(node.right, dist+1);
            }

            if (hmap.containsKey(dist)) {
                List<Integer> temp = hmap.get(dist);
                temp.add(node.val);
                hmap.put(dist, temp);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(node.val);
                hmap.put(dist, temp);
            }
        }

        for (Map.Entry<Integer, List<Integer>> val : hmap.entrySet()) {
            result.add(val.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        VerticalTraversal v = new VerticalTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(v.verticalOrder(root));


    }
}
